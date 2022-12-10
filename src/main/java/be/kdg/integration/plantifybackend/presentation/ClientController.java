package be.kdg.integration.plantifybackend.presentation;

import be.kdg.integration.plantifybackend.domain.Client;
import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.service.ArduinoService;
import be.kdg.integration.plantifybackend.service.ClientService;
import be.kdg.integration.plantifybackend.service.PlantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClientController {

    PlantService plantService;
    ClientService clientService;
    ArduinoService arduinoService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ClientController(PlantService plantService, ClientService clientService, ArduinoService arduinoService) {
        this.plantService = plantService;
        this.clientService = clientService;
        this.arduinoService = arduinoService;
    }




    // To-do
    // When deleting a client, we have to delete his arduinos first
    // Then his plants
    // Then his actual account
    @GetMapping("removeUser")
    public void deleteClient(){
        String email="fake@email.com";
        String pass ="12345";
        logger.debug("delete client request received");
        // TO del arduino, we need its phys id
        // TO del plant, we need its id
        List<Plant> clientPlants = plantService.readPlants().stream()
                .filter(plant -> plant.getEmailUser().equals(email)).toList();

        clientPlants.forEach(plant -> {
            arduinoService.removeArduino(plant.getArduino().getPhysicalIdentifier());
            plantService.removePlant(plant.getId());
        });


        clientService.removeClient(new Client(email,pass));

    }

    @PostMapping("removeUser")
    public String removeUser() {
        return "redirect:/index";
    }

}
