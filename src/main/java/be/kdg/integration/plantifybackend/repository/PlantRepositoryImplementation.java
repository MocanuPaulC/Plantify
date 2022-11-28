package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.gson.PlantDetailsRowMapper;
import be.kdg.integration.plantifybackend.domain.gson.PlantRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

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
        //harro, I'm smol Asian man
        String getPlants = "SELECT plantid,useremail, plantname,planttype, arduinophysicalidentifier, series " +
                "FROM currentplants " +
                "JOIN arduino a on a.physicalidentifier = currentplants.arduinophysicalidentifier";
        plantList = jdbcTemplate.query(getPlants, new PlantRowMapper());
        String getDetails = """
                SELECT p.plantid, p.temperature,p.humidity,p.moisture,p.light,p.refreshtime
                FROM plantcurrentdata AS p
                INNER JOIN (
                  SELECT plantid, MAX(refreshtime) AS date
                  FROM plantcurrentdata
                  GROUP BY plantid
                ) tm ON p.plantid = tm.plantid AND p.refreshtime = tm.date;""" ;
        List<Plant> tempPlantList = jdbcTemplate.query(getDetails,new PlantDetailsRowMapper());
        for (Plant value : tempPlantList) {
            for (Plant plant : plantList) {
                if (plant.getId() == value.getId()) {
                    plant.setDetails(value.getDetails());
                }
            }
        }
        System.out.println(plantList);
    }


    @Override
    public Plant savePlant(Plant plant, String userEmail) {
        String saveSql =
                String.format("INSERT INTO currentplants (plantname,useremail,planttype,arduinophysicalidentifier) " +
                        "VALUES ('%s','%s','%s',%d)", plant.getName(), userEmail, plant.getTypeOfPlant(),plant.getArduino().getPhysicalIdentifier());
        jdbcTemplate.execute(saveSql);
        plant.setId(plantList.stream().mapToInt(Plant::getId).max().orElse(0) + 1);
        plant.setEmailUser(userEmail);
        plantList.add(plant);
        return plant;
    }


    public void saveCurrentReadingsToDB(Plant.Details details, int physicalId){
//        int plantId=plantList.stream().filter(plant -> plant.getArduino().getPhysicalIdentifier()==physicalId).findFirst().get().

        String getPlantId = String.format("Select plantid FROM currentplants WHERE arduinophysicalidentifier = %d",physicalId);
        int plantId=jdbcTemplate.queryForObject(getPlantId, Integer.class);
        String sql=String.format("INSERT INTO plantCurrentData (plantid, temperature, humidity,moisture, light, refreshtime)" +
                "VALUES (%d, %f, %f, %f, %f,CURRENT_TIMESTAMP)",plantId,details.getTemperature(),details.getHumidity(),
                details.getMoisture(),details.getBrightness());
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
            double temperatureAvg=0;
            double humidityAvg=0;
            double moistureAvg=0;
            double lightAvg=0;
            int counter=0;
            double minimumTemp=0;
            double maximumTemp=0;
            double minimumHumidity=0;
            double maximumHumidity=0;
            double minimumMoisture=0;
            double maximumMoisture=0;
            double minimumLight=0;
            double maximumLight=0;
            for (Plant plant : plantList ) {
                if(plant.getId()==plantID){
                    temperatureAvg+=plant.getDetails().getTemperature();
                    humidityAvg+=plant.getDetails().getHumidity();
                    moistureAvg+=plant.getDetails().getMoisture();
                    lightAvg+=plant.getDetails().getBrightness();

                    if(counter==0){
                        minimumTemp=plant.getDetails().getTemperature();
                        maximumTemp=plant.getDetails().getTemperature();
                        minimumHumidity=plant.getDetails().getHumidity();
                        maximumHumidity=plant.getDetails().getHumidity();
                        minimumMoisture=plant.getDetails().getMoisture();
                        maximumMoisture=plant.getDetails().getMoisture();
                        minimumLight=plant.getDetails().getBrightness();
                        maximumLight=plant.getDetails().getBrightness();
                    }
                    else{
                        if(minimumTemp>plant.getDetails().getTemperature()){
                            minimumTemp=plant.getDetails().getTemperature();
                        }
                        if(maximumTemp<plant.getDetails().getTemperature()){
                            maximumTemp=plant.getDetails().getTemperature();
                        }
                        if(minimumHumidity>plant.getDetails().getHumidity()){
                            minimumHumidity=plant.getDetails().getHumidity();
                        }
                        if(maximumHumidity<plant.getDetails().getHumidity()){
                            maximumHumidity=plant.getDetails().getHumidity();
                        }
                        if(minimumMoisture>plant.getDetails().getMoisture()){
                            minimumMoisture=plant.getDetails().getMoisture();
                        }
                        if(maximumMoisture<plant.getDetails().getMoisture()){
                            maximumMoisture=plant.getDetails().getMoisture();
                        }
                        if(minimumLight>plant.getDetails().getBrightness()){
                            minimumLight=plant.getDetails().getBrightness();
                        }
                        if(maximumLight<plant.getDetails().getBrightness()){
                            maximumLight=plant.getDetails().getBrightness();
                        }
                    }
                    counter++;
                }
            }
            temperatureAvg=temperatureAvg/counter;
            humidityAvg=humidityAvg/counter;
            moistureAvg=moistureAvg/counter;
            lightAvg=lightAvg/counter;

            // in the database INSERT the average gets rounded down
            String postData=String.format(Locale.US ,"INSERT INTO plantDataArchive " +
                    "(plantID, temperatureAvg, humidityAvg, moistureAvg, lightAvg, " +
                    "minimumTemperature, maximumTemperature, minimumHumidity, maximumHumidity, " +
                    "minimumMoisture, maximumMoisture, minimumLight, maximumLight, totalRowsArchived) " +
                    "VALUES(%d, %f, %f, %f, %f, " +
                    "%f, %f, %f, %f, %f, %f, %f, %f, %d)",
                    plantID, temperatureAvg, humidityAvg, moistureAvg, lightAvg,
                    minimumTemp, maximumTemp, minimumHumidity, maximumHumidity, minimumMoisture,
                    maximumMoisture, minimumLight, maximumLight, counter);
            jdbcTemplate.execute(postData);
        }
        String clearTable="DROP TABLE IF EXISTS plantCurrentData; " +
                "CREATE TABLE plantCurrentData( " +
                "    ID INT NOT NULL " +
                "        GENERATED ALWAYS AS IDENTITY " +
                "        PRIMARY KEY, " +
                "    plantID INT NOT NULL " +
                "        CONSTRAINT fk_plantID REFERENCES currentPlants (plantID) " +
                "            ON DELETE CASCADE, " +
                "    temperature NUMERIC(10) NOT NULL, " +
                "    humidity NUMERIC(10) NOT NULL, " +
                "    moisture NUMERIC(10) NOT NULL, " +
                "    light NUMERIC(10) NOT NULL, " +
                "    refreshTime TIMESTAMP NOT NULL " +
                "        DEFAULT CURRENT_TIMESTAMP " +
                "); ";
        jdbcTemplate.execute(clearTable);
    }
}

