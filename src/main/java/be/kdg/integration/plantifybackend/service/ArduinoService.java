package be.kdg.integration.plantifybackend.service;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.RGBColor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface ArduinoService {
    Arduino addArduino(String series,int physicalIdentifier);

    void setLedSetting(int physicalId, boolean base);
    void changeColor(int physicalId, RGBColor color);
    void getArduinoList(List<Plant> plantList);

    String postMapping(int PhysicalId);

}
