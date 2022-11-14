package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.Arduino;
import org.springframework.stereotype.Component;

public interface ArduinoRepository {

    Arduino saveArduino(Arduino arduino);
}
