package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.hibernate.ArduinoDao;
import org.springframework.data.repository.CrudRepository;

public interface ArduinoRepository extends CrudRepository<ArduinoDao, Integer> {
}
