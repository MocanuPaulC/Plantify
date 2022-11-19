package be.kdg.integration.plantifybackend.domain;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;

public class Plant implements Serializable {

    public class Details{
        private double temperature;
        private double brightness;
        private double humidity;
        private double moisture;


        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public void setBrightness(double brightness) {
            this.brightness = brightness;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        public void setMoisture(double moisture) {
            this.moisture = moisture;
        }

        public double getTemperature() {
            return temperature;
        }

        public double getBrightness() {
            return brightness;
        }

        public double getHumidity() {
            return humidity;
        }

        public double getMoisture() {
            return moisture;
        }

        @Override
        public String toString() {
            return "Details{" +
                    "temperature=" + temperature +
                    ", brightness=" + brightness +
                    ", humidity=" + humidity +
                    ", moisture=" + moisture +
                    '}';
        }
    }

    private String name;
    private PlantType typeOfPlant;
    private Arduino arduino;
    private int id;
    private String emailUser;

    public Arduino getArduino() {
        return arduino;
    }

    private Details details=new Details();

    public void setDetails(Details details){
        this.details.setHumidity(details.getHumidity());
        this.details.setTemperature(details.getTemperature());
        this.details.setMoisture(details.getMoisture());
        this.details.setBrightness(details.getBrightness());
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", typeOfPlant=" + typeOfPlant +
                ", id=" + id +
                ", details=" + details +
                '}';
    }

    public Plant() {
    }

    public Plant(String name, PlantType typeOfPlant, Arduino arduino) {
        this.name = name;
        this.typeOfPlant = typeOfPlant;
        this.arduino = arduino;
//        this.emailUser= emailUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlantType getTypeOfPlant() {
        return typeOfPlant;
    }

    public void setTypeOfPlant(PlantType typeOfPlant) {
        this.typeOfPlant = typeOfPlant;
    }


    public Details getDetails() {
        return details;
    }


    public void setArduino(Arduino arduino) {
        this.arduino = arduino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}


