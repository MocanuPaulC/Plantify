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
        // to modify based on UserId
        String getPlants = "SELECT plantid, plantname,planttype FROM currentplants";
        plantList = jdbcTemplate.query(getPlants, new PlantRowMapper());
        plantList.forEach(Plant::bufferArduino);
        getCurrentReadings();
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
        getCurrentReadings();
        return plant;
    }


    @Override
    public void getCurrentReadings() {

        List<String> plantJsonsWithIds = plantList.stream().map(Plant::getSensorData).toList();
        List<String> plantIds = plantList.stream().map(Plant::getSensorData).map(s -> String.valueOf(s.charAt(3))).toList();
        List<String> jsons = plantJsonsWithIds.stream().map(plant -> plant.substring(5,plant.length()-4)).toList();

        Gson gson = new Gson();


        for (int i = 0 ; i < plantList.size();i++){
            for(int j = 0 ; j<plantList.size();j++){
                if(plantIds.get(i).equals(String.valueOf(plantList.get(j).getId()))){
                    Plant.Details plant = gson.fromJson(jsons.get(j),Plant.Details.class);
                    plantList.get(j).setDetails(plant);
                }
            }

        }

    }
}

