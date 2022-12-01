package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.RGBColor;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ArduinoRepository {

    Arduino saveArduino(Arduino arduino);

    List<Arduino> arduinoList();

    void setLedSetting(int physicalId, boolean base);
    void changeColor(int physicalId, RGBColor color);
    void getArduinoList(List<Plant> plantList);
    void deleteArduino(int physicalId);
}
