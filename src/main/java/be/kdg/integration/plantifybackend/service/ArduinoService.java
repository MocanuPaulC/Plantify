package be.kdg.integration.plantifybackend.service;

import be.kdg.integration.plantifybackend.domain.Arduino;

import java.util.List;



public interface ArduinoService {
    Arduino addArduino(String series,int physicalIdentifier);

    void setLedSetting(int physicalId, boolean base);
    void changeColor(int physicalId, short red, short green, short blue);
    //void setArduinoList(List<Plant> plantList);

    List<Arduino> getArduinoList();

    String postMapping(int PhysicalId);

    void removeArduino(int physicalIdentifier);

}
