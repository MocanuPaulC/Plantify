package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.Client;
import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.hibernate.ArchiveDao;
import be.kdg.integration.plantifybackend.domain.gson.PlantForecastingMapper;

import java.util.List;

public interface PlantRepository {

    void saveCurrentReadingsToDB(Plant.Details details, int plantId);
    Plant savePlant(Plant plant, Client client);

    List<ArchiveDao> getArchiveDaos();
    void getPlantsFromDB();

    Plant setPlantId(Plant plant);
    void updateDBArchive();

    List<Plant> getPlants();

    int getPhysicalIdentifier(int plantId);

    void deletePlant(int id);

    PlantForecastingMapper getForecastingData(int plantId);
}
