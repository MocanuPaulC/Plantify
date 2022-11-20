package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.RGBColor;
import org.springframework.stereotype.Component;

public interface ArduinoRepository {

    Arduino saveArduino(Arduino arduino);

    void setLedSetting(int physicalId, boolean base);
    void changeColor(int physicalId, RGBColor color);


}
