package be.kdg.integration.plantifybackend.presentation;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.PlantType;
import be.kdg.integration.plantifybackend.domain.User;
import be.kdg.integration.plantifybackend.presentation.viewModel.PlantViewModel;
import be.kdg.integration.plantifybackend.service.ArduinoService;
import be.kdg.integration.plantifybackend.service.PlantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * controller for addPlant.html, functionality for adding a plant
 */
@Controller
public class AddPlantController {
    PlantService plantService;

    ArduinoService arduinoService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public AddPlantController(PlantService plantService, ArduinoService arduinoService) {
        this.plantService = plantService;
        this.arduinoService = arduinoService;
    }

    /**
     * shows the addPlant.html page
     * @param model attributes added:
     *              - plantTypes: list of the types of plant for the select input
     *              - plantViewModel: passes on the ViewModel for collecting data and validation
     * @return addplant.html
     */
    @GetMapping("addPlant")
    public String showAddPlant(Model model) {
        model.addAttribute("loggedInOrNot",true);
        List<PlantType> plantTypes = Arrays.stream(PlantType.values()).toList();
        model.addAttribute("plantTypes", plantTypes);
        model.addAttribute("add", "chill");
        model.addAttribute("plantViewModel", new PlantViewModel());

        return "addplant";
    }


    /**
     * handles the form input
     * @param httpSession used to retrieve the User
     * @param plantViewModel used to retrieve the data from the form
     * @param errors used to detect and retrieve any errors
     * @param model used to
     * @return returns addPlant.html when an error is detected server-side, otherwise returns plants
     */
    @PostMapping("addPlant")
    public String addPlant(HttpSession httpSession, @Valid @ModelAttribute("plantViewModel") PlantViewModel
                                       plantViewModel, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> {
                logger.error(error.toString());
            });
            List<PlantType> plantTypes = Arrays.stream(PlantType.values()).toList();
            model.addAttribute("plantTypes", plantTypes);
            model.addAttribute("plants", plantService.readPlants());
            return "addPlant";
        }

        User user = (User) httpSession.getAttribute("user");
        Arduino arduino = this.arduinoService.addArduino(plantViewModel.getArduinoSeries(), plantViewModel.getPhysicalAddress());
//        this.arduinoService.addArduino(arduinoSeries,Integer.parseInt(psysicalAddress));
        this.plantService.addPlant(plantViewModel.getName(), plantViewModel.getType(), arduino,user.getEmail());
        return "redirect:/plants";
    }
}
