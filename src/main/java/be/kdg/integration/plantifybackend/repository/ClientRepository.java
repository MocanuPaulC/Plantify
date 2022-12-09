package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.Client;
import be.kdg.integration.plantifybackend.domain.hibernate.ArduinoDao;
import be.kdg.integration.plantifybackend.domain.hibernate.ClientDao;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientDao, String> {

}
