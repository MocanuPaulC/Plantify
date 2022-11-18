package be.kdg.integration.plantifybackend.presentation.viewModel;

import be.kdg.integration.plantifybackend.domain.PlantType;

import javax.validation.constraints.NotEmpty;

public class PlantControllerViewModel {
    @NotEmpty(message = "Cannot be empty!")
    public String name;
    public PlantType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlantType getType() {
        return type;
    }

    public void setType(PlantType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PlantControllerViewModel{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
