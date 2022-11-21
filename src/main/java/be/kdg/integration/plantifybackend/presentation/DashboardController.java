package be.kdg.integration.plantifybackend.presentation;

import be.kdg.integration.plantifybackend.service.ArduinoService;
import be.kdg.integration.plantifybackend.service.PlantService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    PlantService plantService;
    Gson gson = new Gson();
    ArduinoService arduinoService;

    @Autowired
    public DashboardController(PlantService plantService, ArduinoService arduinoService) {
        this.plantService = plantService;
        this.arduinoService = arduinoService;
    }
    @GetMapping("/dashboard")
    public String showIndexView(Model model) {

        model.addAttribute("plants", plantService.readPlants());


        return "dashboard";
    }
}
