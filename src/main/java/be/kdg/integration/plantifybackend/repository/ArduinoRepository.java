package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.Util.RGBColor;

import java.util.List;

public interface ArduinoRepository {
    Arduino saveArduino(Arduino arduino);

    List<Arduino> getArduinoList();

    void setLedSetting(int physicalId, boolean base);
    void changeColor(int physicalId, RGBColor color);
    void deleteArduino(int physicalId);

}
