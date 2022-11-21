package be.kdg.integration.plantifybackend.service;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.RGBColor;
import be.kdg.integration.plantifybackend.repository.ArduinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArduinoServiceImplementation implements ArduinoService{

    private ArduinoRepository arduinoRepository;

    @Autowired
    public ArduinoServiceImplementation(ArduinoRepository arduinoRepository) {
        this.arduinoRepository=arduinoRepository;
    }

    @Override
    public void setLedSetting(int physicalId, boolean base) {
        arduinoRepository.setLedSetting(physicalId, base);
    }

    @Override
    public Arduino addArduino(String series, int physicalIdentifier) {
        return this.arduinoRepository.saveArduino(new Arduino(series,physicalIdentifier));
    }

    @Override
    public void getArduinoList(List<Plant> plantList) {
        this.arduinoRepository.getArduinoList(plantList);

    }


    @Override
    public void changeColor(int arduinoId, RGBColor color) {
        arduinoRepository.changeColor(arduinoId, color);
    }

    @Override
    public String postMapping(int physicalID) {
        System.out.println(physicalID + " is the physical id");
        Arduino arduino = arduinoRepository.arduinoList().stream().filter(ar -> ar.getPhysicalIdentifier() == physicalID).toList().get(0);
        return String.format("P%dL%dC%03d,%03d,%03d",arduino.getPumpInstruction(),arduino.getLedSetting() ? 1 : 0
                ,arduino.getLedColor().getRed(),arduino.getLedColor().getGreen(),arduino.getLedColor().getBlue());
    }
}
