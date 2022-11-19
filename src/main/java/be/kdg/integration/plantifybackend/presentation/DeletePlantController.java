package be.kdg.integration.plantifybackend.presentation;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.PlantType;
import be.kdg.integration.plantifybackend.service.ArduinoService;
import be.kdg.integration.plantifybackend.service.PlantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeletePlantController {
    PlantService plantService;

    ArduinoService arduinoService;

    public DeletePlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("removePlant")
    public String showAddPlant(Model model) {
        model.addAttribute("remove");
        return "removePlant";
    }

    @PostMapping("removePlant")
    public String addPlant(String name, String plantType, String arduinoSeries, String physicalId) {
        Arduino arduino = this.arduinoService.addArduino(arduinoSeries, Integer.parseInt(physicalId));
        this.plantService.removePlant(name, PlantType.valueOf(plantType), arduino);
        return "redirect:/plants";
    }
}