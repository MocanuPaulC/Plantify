package be.kdg.integration.plantifybackend.service;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.PlantType;
import be.kdg.integration.plantifybackend.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PlantServiceImplementation implements PlantService{

    private PlantRepository plantRepository;

    @Autowired
    public PlantServiceImplementation(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @Override
    public Plant addPlant(String name, PlantType plantType, Arduino arduino) {
        return plantRepository.savePlant(new Plant(name,plantType,arduino));
    }
    public void getPlantFromDB(){
        plantRepository.getPlantsFromDB();
    }

    public List<Plant> readPlants(){
        return plantRepository.getPlants();
    }

    @Override
    public Plant addDummyPlant(String name, PlantType plantType) {
        return null;
    }

    @Override
    public void refreshPlantData() {
        plantRepository.getCurrentReadings();
    }
}
