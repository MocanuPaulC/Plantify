package be.kdg.integration.plantifybackend.domain;

import java.sql.Timestamp;

public class PlantData {
    int plantID;
    int temperature;
    int humidity;
    int moisture;
    int light;

    public PlantData() {
        this.plantID = 0;
        this.temperature = 0;
        this.humidity = 0;
        this.moisture = 0;
        this.light = 0;
    }

    public int getPlantID() {
        return plantID;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getMoisture() {
        return moisture;
    }

    public int getLight() {
        return light;
    }

    public void addPlantID(int plantID) {
        this.plantID += plantID;
    }

    public void addTemperature(int temperature) {
        this.temperature += temperature;
    }

    public void addHumidity(int humidity) {
        this.humidity += humidity;
    }

    public void addMoisture(int moisture) {
        this.moisture += moisture;
    }

    public void addLight(int light) {
        this.light += light;
    }
}
