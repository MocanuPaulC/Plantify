package be.kdg.integration.plantifybackend.service;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.PlantType;
import java.util.List;

public interface PlantService {
    Plant addPlant(String name, PlantType plantType, Arduino arduino);

    void getPlantFromDB();

    void refreshPlantData();

    List<Plant> readPlants();

}
