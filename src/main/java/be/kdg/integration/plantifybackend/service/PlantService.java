package be.kdg.integration.plantifybackend.service;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.PlantType;
import be.kdg.integration.plantifybackend.domain.User;

import java.util.List;

public interface PlantService {
    Plant addPlant(String name, PlantType plantType, Arduino arduino, String emailUser);

    void getPlantFromDB();

    void updatePlantData(Plant.Details details,int physicalId);

    void saveReadingsToDB(Plant.Details details, int plantId);

    List<Plant> readPlants();

    void removePlant(int id);
}
