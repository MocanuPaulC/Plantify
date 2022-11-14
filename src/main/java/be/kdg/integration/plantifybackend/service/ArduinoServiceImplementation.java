package be.kdg.integration.plantifybackend.service;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.repository.ArduinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArduinoServiceImplementation implements ArduinoService{

    private ArduinoRepository arduinoRepository;

    @Autowired
    public ArduinoServiceImplementation(ArduinoRepository arduinoRepository) {
        this.arduinoRepository=arduinoRepository;
    }


    @Override
    public Arduino addArduino(String series, int physicalIdentifier) {
        return this.arduinoRepository.saveArduino(new Arduino(series,physicalIdentifier));
    }
}
