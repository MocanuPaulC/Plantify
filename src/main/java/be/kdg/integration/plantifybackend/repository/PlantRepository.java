package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.Plant;
import org.springframework.stereotype.Component;

import java.util.List;

public interface PlantRepository {

    void saveCurrentReadingsToDB(Plant.Details details, int plantId);
    Plant savePlant(Plant plant);

    void getPlantsFromDB();
    List<Plant> getPlants();

    void updatePlantData(Plant.Details details,int physicalId);

}
