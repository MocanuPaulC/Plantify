package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.Plant;

import java.util.List;

public interface PlantRepository {

    void saveCurrentReadingsToDB(Plant.Details details, int plantId);
    Plant savePlant(Plant plant, String userEmail);

    void getPlantsFromDB();

    void updateDBArchive();

    List<Plant> getPlants();

    void updatePlantData(Plant.Details details,int physicalId);

    void deletePlant(int id);
}
