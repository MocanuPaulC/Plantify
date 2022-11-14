package be.kdg.integration.plantifybackend.service;

import be.kdg.integration.plantifybackend.domain.Arduino;
import org.springframework.stereotype.Component;

@Component
public interface ArduinoService {
    Arduino addArduino(String series,int physicalIdentifier);

}
