package be.kdg.integration.plantifybackend.presentation.viewModel;

import be.kdg.integration.plantifybackend.domain.PlantType;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.core.convert.ConversionService;

import javax.validation.constraints.*;

public class PlantViewModel {
    @NotEmpty(message = "Name can't be empty!")
    private String name;
    @NotNull(message = "type can't be null")
    private PlantType type;
    @NotNull(message = "Physical Address can't be empty!")
    @PositiveOrZero(message = "Physical Address can't be negative!")
    private int physicalAddress;
    @NotEmpty(message = "Arduino Series can't be empty!")
    private String arduinoSeries;

    public int getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(int physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public String getArduinoSeries() {
        return arduinoSeries;
    }

    public void setArduinoSeries(String arduinoSeries) {
        this.arduinoSeries = arduinoSeries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlantType getType() {
        return type;
    }

    public void setType(String type) {
        ConversionService conversionService= new ApplicationConversionService();
        this.type = conversionService.convert(type, PlantType.class);
    }

    @Override
    public String toString() {
        return "PlantControllerViewModel{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", physicalAddress=" + physicalAddress +
                ", arduinoSeries='" + arduinoSeries + '\'' +
                '}';
    }
}
