package be.kdg.integration.plantifybackend.service;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.Client;
import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.PlantType;
import be.kdg.integration.plantifybackend.domain.mappers.PlantForecastingMapper;
import be.kdg.integration.plantifybackend.domain.hibernate.ArchiveDao;

import java.util.List;

public interface PlantService {
    Plant addPlant(String name, PlantType plantType, Arduino arduino, Client client);

    void getPlantFromDB();

    void saveReadingsToDB(Plant.Details details, int plantId);
    void updateDBArchive();

    List<Plant> readPlants();

    List<ArchiveDao> getArchiveByPlantId(int id);


    int getPlantPhysicalIdentifier(int plantId);

    void removePlant(int id);

    PlantForecastingMapper getForecastingData(int plantId);
}
