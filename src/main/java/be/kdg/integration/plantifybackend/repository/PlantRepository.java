package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.Client;
import be.kdg.integration.plantifybackend.domain.Plant;

import java.util.List;

public interface PlantRepository {

    void saveCurrentReadingsToDB(Plant.Details details, int plantId);
    Plant savePlant(Plant plant, Client client);

    void getPlantsFromDB();

    void updateDBArchive();

    List<Plant> getPlants();

    int getPhysicalIdentifier(int plantId);

    void deletePlant(int id);
}
