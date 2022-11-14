package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.gson.PlantRowMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlantRepositoryImplementation implements PlantRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    List<Plant> plantList;

    @Autowired
    public PlantRepositoryImplementation() {
        plantList = new ArrayList<>();

    }

    @Override
    public List<Plant> getPlants() {
        return plantList;
    }

    @Override
    public void getPlantsFromDB(){
        // to modify based on UserID
        String getPlants = "SELECT plantid, plantname,planttype FROM currentplants";
        plantList = jdbcTemplate.query(getPlants, new PlantRowMapper());
        System.out.println(plantList);
    }


    @Override
    public Plant savePlant(Plant plant) {
        String saveSql =
                String.format("INSERT INTO currentplants (plantname,dateadded,planttype) " +
                        "VALUES ('%s',CURRENT_TIMESTAMP,'%s')", plant.getName(), plant.getTypeOfPlant());
        jdbcTemplate.execute(saveSql);
        plant.setId(plantList.stream().mapToInt(Plant::getId).max().orElse(0) + 1);
        plantList.add(plant);
        return plant;
    }


    public void saveCurrentReadingsToDB(Plant.Details details, int plantId){
        String sql=String.format("INSERT INTO plantCurrentData (plantid,temperature, humidity,moisture, light, refreshtime)" +
                "VALUES (%d,%f, %f, %f, %f,CURRENT_TIMESTAMP)",plantId,details.getTemperature(),details.getHumidity(),details.getMoisture(),details.getBrightness());
        jdbcTemplate.execute(sql);
    }


}

