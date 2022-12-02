package be.kdg.integration.plantifybackend.presentation;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.PlantType;
import be.kdg.integration.plantifybackend.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Scanner;

/**
 * redundant testing class
 */
@Component
public class View {

    Scanner scanner = new Scanner(System.in);
    private PlantService plantService;

    @Autowired
    public View(PlantService plantService) {
        this.plantService = plantService;
    }

    // to delete, only for testing purposes
    public void showMenu() {
        int choice;
        boolean show = true;
        plantService.getPlantFromDB();
        while (show) {
            System.out.println("""
                    1) Show plant details
                    2) Refresh plant details
                    3) Add plant
                    0) Exit
                    """);
            choice = scanner.nextInt();

            switch (choice) {
                case 0 -> show = false;
                case 1 -> showPlant();
                case 3 -> addPlant();
            }
        }


    }

    public void showPlant() {
        System.out.println(plantService.readPlants());
    }

//    public void refreshPlantDetails() {
//        plantService.refreshPlantData();
//    }

    public void addPlant() {
        System.out.println("What's the name of the plant?");
        String name = scanner.next();
        System.out.println("What type of plant do you have?(DESERT, WATER, MOUNTAIN, PLAIN)");
        String type = scanner.next();
        System.out.println("What series of our product do you own? (1,2,3,4)");
        String series = scanner.next();
        plantService.addPlant(name, PlantType.valueOf(type.toUpperCase(Locale.ROOT)), new Arduino(series,101),
                "example@email.com");

    }

}
