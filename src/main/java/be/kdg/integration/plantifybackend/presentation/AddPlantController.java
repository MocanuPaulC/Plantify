package be.kdg.integration.plantifybackend.presentation;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.PlantType;
import be.kdg.integration.plantifybackend.domain.User;
import be.kdg.integration.plantifybackend.service.ArduinoService;
import be.kdg.integration.plantifybackend.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class AddPlantController {
    PlantService plantService;

    ArduinoService arduinoService;

    @Autowired
    public AddPlantController(PlantService plantService, ArduinoService arduinoService) {
        this.plantService = plantService;
        this.arduinoService = arduinoService;
    }

    @GetMapping("addPlant")
    public String showAddPlant(Model model) {
        model.addAttribute("add", "chill");
        return "addPlant";
    }


    // add viewModel here as well
    @PostMapping("addPlant")
    public String addPlant(String name, String plantType, String arduinoSeries, String psysicalAddress, HttpSession httpSession) {

        User user = (User) httpSession.getAttribute("user");
        Arduino arduino = this.arduinoService.addArduino(arduinoSeries, Integer.parseInt(psysicalAddress));
//        this.arduinoService.addArduino(arduinoSeries,Integer.parseInt(psysicalAddress));
        this.plantService.addPlant(name, PlantType.valueOf(plantType.toUpperCase(Locale.ROOT)), arduino,user.getEmail());
        return "redirect:/plants";
    }
}
