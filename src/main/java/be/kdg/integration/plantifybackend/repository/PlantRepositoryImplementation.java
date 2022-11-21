package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.PlantData;
import be.kdg.integration.plantifybackend.domain.gson.PlantDetailsRowMapper;
import be.kdg.integration.plantifybackend.domain.gson.PlantRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class PlantRepositoryImplementation implements PlantRepository {
    JdbcTemplate jdbcTemplate;

    List<Plant> plantList;

    @Autowired
    public PlantRepositoryImplementation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        plantList = new ArrayList<>();

    }

    @Override
    public List<Plant> getPlants() {
        return plantList;
    }

    @Override
    public void getPlantsFromDB(){

        String getPlants = "SELECT plantid, plantname,planttype, arduinophysicalidentifier, series FROM currentplants JOIN arduino a on a.physicalidentifier = currentplants.arduinophysicalidentifier";
        plantList = jdbcTemplate.query(getPlants, new PlantRowMapper());
        System.out.println(plantList);
    }


    @Override
    public Plant savePlant(Plant plant, String userEmail) {
        String saveSql =
                String.format("INSERT INTO currentplants (plantname,useremail,planttype,arduinophysicalidentifier) " +
                        "VALUES ('%s','%s','%s',%d)", plant.getName(), userEmail, plant.getTypeOfPlant(),plant.getArduino().getPhysicalIdentifier());
        jdbcTemplate.execute(saveSql);
        plant.setId(plantList.stream().mapToInt(Plant::getId).max().orElse(0) + 1);
        plantList.add(plant);
        return plant;
    }


    public void saveCurrentReadingsToDB(Plant.Details details, int physicalId){
//        int plantId=plantList.stream().filter(plant -> plant.getArduino().getPhysicalIdentifier()==physicalId).findFirst().get().

        String getPlantId = String.format("Select plantid FROM currentplants WHERE arduinophysicalidentifier = %d",physicalId);
        int plantId=jdbcTemplate.queryForObject(getPlantId, Integer.class);
        String sql=String.format("INSERT INTO plantCurrentData (plantid, temperature, humidity,moisture, light, refreshtime)" +
                "VALUES (%d, %f, %f, %f, %f,CURRENT_TIMESTAMP)",plantId,details.getTemperature(),details.getHumidity(),details.getMoisture(),details.getBrightness());
        jdbcTemplate.execute(sql);
    }

    @Override
    public void updatePlantData(Plant.Details details, int physicalId) {
        plantList.stream().filter(plant-> plant.getArduino().getPhysicalIdentifier()==physicalId)
                .forEach(plant -> plant.setDetails(details));
    }

    @Override
    public void deletePlant(int id){

//        String saveSql = "DELETE FROM currentplants WHERE ID ="+id;
//        jdbcTemplate.execute(saveSql);
//        plantList.remove(plantList.stream().filter(plant -> plant.getId()==id).findFirst());
//        return plant;
    }

    @Override
    public void updateDBArchive() {
        String pullData = "SELECT * FROM plantCurrentData";
        List<Plant> plantList = jdbcTemplate.query(pullData, new PlantDetailsRowMapper());
        String pullplantID = "SELECT DISTINCT plantID FROM plantCurrentData";
        List<Integer> plantIDList = jdbcTemplate.queryForList(pullplantID, Integer.class);

        for (Integer plantID : plantIDList) {
            int temperatureAvg=0;
            int humidityAvg=0;
            int moistureAvg=0;
            int lightAvg=0;
            int counter=0;
            for (Plant plant : plantList ) {
                if(plant.getId()==plantID){
                    temperatureAvg+=plant.getDetails().getTemperature();
                    humidityAvg+=plant.getDetails().getHumidity();
                    moistureAvg+=plant.getDetails().getMoisture();
                    lightAvg+=plant.getDetails().getBrightness();
                    counter++;
                }
            }
            temperatureAvg=temperatureAvg/counter;
            humidityAvg=humidityAvg/counter;
            moistureAvg=moistureAvg/counter;
            lightAvg=lightAvg/counter;

            // in the database INSERT the average gets rounded down
            String postData=String.format("INSERT INTO plantDataArchive " +
                    "(plantID, temperatureAvg, humidityAvg, moistureAvg, lightAvg) " +
                    "VALUES(%d, %d, %d, %d, %d)", plantID, temperatureAvg, humidityAvg, moistureAvg, lightAvg);
            jdbcTemplate.execute(postData);
        }
        String clearTable="DROP TABLE IF EXISTS plantCurrentData; " +
            "CREATE TABLE plantCurrentData( " +
            "ID INT NOT NULL " +
            "   GENERATED ALWAYS AS IDENTITY " +
            "   PRIMARY KEY, " +
            "plantID INT NOT NULL " +
            "   CONSTRAINT fk_plantID REFERENCES currentPlants (plantID) " +
            "       ON DELETE CASCADE, " +
            "temperature NUMERIC(10) NOT NULL, " +
            "humidity NUMERIC(10) NOT NULL, " +
            "moisture NUMERIC(10) NOT NULL, " +
            "light NUMERIC(10) NOT NULL, " +
            "refreshTime TIMESTAMP NOT NULL " +
            "   DEFAULT CURRENT_TIMESTAMP " +
            "); ";
        jdbcTemplate.execute(clearTable);
    }
}

