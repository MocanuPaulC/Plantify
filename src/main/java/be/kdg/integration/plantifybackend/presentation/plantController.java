package be.kdg.integration.plantifybackend.presentation;

import be.kdg.integration.plantifybackend.service.PlantServiceImplementation;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Component
@RequestMapping("/plants")
public class plantController {
    PlantServiceImplementation plantServiceImplementation;

    public plantController(PlantServiceImplementation plantServiceImplementation) {
        this.plantServiceImplementation = plantServiceImplementation;
    }

    @GetMapping
    public String showPlantsView(Model model) {
        model.addAttribute("plants", plantServiceImplementation.readPlants());
        return "index";
    }
}

