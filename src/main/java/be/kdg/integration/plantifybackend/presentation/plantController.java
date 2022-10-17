package be.kdg.integration.plantifybackend.presentation;

import be.kdg.integration.plantifybackend.service.PlantService;
import be.kdg.integration.plantifybackend.service.PlantServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/plants")
public class plantController {
    PlantService plantService;

    @Autowired
    public plantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping
    public String showPlantsView(Model model) {
        model.addAttribute("plants", plantService.readPlants());
        return "index";
    }


    @PostMapping
    public String refreshData(){
        plantService.refreshPlantData();
        return "redirect:/plants";
    }
}

