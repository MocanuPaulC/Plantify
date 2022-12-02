package be.kdg.integration.plantifybackend.service;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.PlantType;
import be.kdg.integration.plantifybackend.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * service class for handling plant data
 */
@Component
public class PlantServiceImplementation implements PlantService{

    private PlantRepository plantRepository;

    @Autowired
    public PlantServiceImplementation(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    /**
     * adds a plant to the database
     * @param name name of the plant
     * @param plantType enum type of the plant
     * @param arduino arduino connected to the plant
     * @param emailUser email of the owner of the plant
     * @return function from the repository
     */
    @Override
    public Plant addPlant(String name, PlantType plantType, Arduino arduino, String emailUser) {
        return plantRepository.savePlant(new Plant(name,plantType,arduino), emailUser);
    }
    public void getPlantFromDB(){
        plantRepository.getPlantsFromDB();
    }

    /**
     * gets all the plant
     * @return function from the repository
     */
    public List<Plant> readPlants(){
        return plantRepository.getPlants();
    }

    /**
     * calls function from the repository to update plant data based on ID of the plant
     * @param details readings from the arduino
     * @param plantId id of the plant that is being read
     */
    @Override
    public void saveReadingsToDB(Plant.Details details, int plantId){
        plantRepository.saveCurrentReadingsToDB(details, plantId);
    }

    @Override
    public Arduino getPlantArduino(int plantId) {
        return plantRepository.getArduino(plantId);
    }

    /**
     * calls function from the repository to update the archive
     */
    @Override
    public void updateDBArchive(){
        plantRepository.updateDBArchive();
    }

//    Refactor

    /**
     * calls function from the repository to delete a plant
     * @param id
     */
    @Override
    public void removePlant(int id) {
        plantRepository.deletePlant(id);
    }

    //    Refactor

    /**
     * calls function from the repository to update plant data based on ID of the arduino
     * @param details readings from the arduino
     * @param physicalId id from the arduino that is reading
     */
    @Override
    public void updatePlantData(Plant.Details details,int physicalId) {
        plantRepository.updatePlantData(details,physicalId);
    }
}
