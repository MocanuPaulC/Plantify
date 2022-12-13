package be.kdg.integration.plantifybackend.service;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.PlantType;

import java.sql.SQLException;
import java.util.List;



public interface ArduinoService {
    Arduino addArduino(String series,int physicalIdentifier) throws SQLException;

    void setLedSetting(int physicalId, boolean base);
    void changeColor(int physicalId, short red, short green, short blue);
    //void setArduinoList(List<Plant> plantList);

    List<Arduino> getArduinoList();

    String postMapping(int PhysicalId);
    String SetUpConfig(PlantType plantType);
    void removeArduino(int physicalIdentifier);

}
