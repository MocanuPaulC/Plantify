package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.gson.PlantRowMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
        // to modify based on UserID//

        // Create plants without arduino
        //
        // Here modify the query to get colums from currentplants and from arduino
        // Use an inner join of the arduino physical Id
        // Change the plant row mapper to make the arduino first then
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

        String sql=String.format("INSERT INTO plantCurrentData (temperature, humidity,moisture, light, refreshtime)" +
                "VALUES (%f, %f, %f, %f,CURRENT_TIMESTAMP)",details.getTemperature(),details.getHumidity(),details.getMoisture(),details.getBrightness());
        jdbcTemplate.execute(sql);
    }

    @Override
    public void updatePlantData(Plant.Details details, int physicalId) {
        plantList.stream().filter(plant-> plant.getArduino().getPhysicalIdentifier()==physicalId)
                .forEach(plant -> plant.setDetails(details));
    }

    @Override
    public void deletePlant(int id){

        String saveSql = "DELETE FROM currentplants WHERE ID ="+id;
        jdbcTemplate.execute(saveSql);
        plantList.remove(plantList.stream().filter(plant -> plant.getId()==id).findFirst());
//        return plant;
    }
}

