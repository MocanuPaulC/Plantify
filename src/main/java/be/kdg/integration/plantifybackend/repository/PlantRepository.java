package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.Plant;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PlantRepository {

    Plant savePlant(Plant plant);

    void getCurrentReadings();

    void getPlantsFromDB();
    List<Plant> getPlants();


}
