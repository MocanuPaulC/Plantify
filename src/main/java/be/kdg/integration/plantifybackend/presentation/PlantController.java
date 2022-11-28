package be.kdg.integration.plantifybackend.presentation;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.PlantType;
import be.kdg.integration.plantifybackend.domain.User;
import be.kdg.integration.plantifybackend.presentation.viewModel.PlantViewModel;
import be.kdg.integration.plantifybackend.service.ArduinoService;
import be.kdg.integration.plantifybackend.service.PlantService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * controller for dashboard.html and adddetails.html
 */
@Controller
public class PlantController {
    PlantService plantService;
    Gson gson = new Gson();
    ArduinoService arduinoService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public PlantController(PlantService plantService, ArduinoService arduinoService) {
        this.plantService = plantService;
        this.arduinoService = arduinoService;
    }

    /**
     * returns dashboard if user is logged in
     * @param httpSession used to retrieve the user
     * @param model used to parse on loggedInOrNot and plants
     * @return dashbaord.html and login.html
     */
    @GetMapping("/plants")
    public String showPlantsView(HttpSession httpSession, Model model) {
        System.out.println("in show plants view");

        User user = (User) httpSession.getAttribute("user");
        if (user != null) {
            String email= ((User)httpSession.getAttribute("user")).getEmail();
            model.addAttribute("loggedInOrNot",true);
//            System.out.println(email);
//            System.out.println(plantService.readPlants().stream()
//                    .filter(plant -> plant.getEmailUser()
//                            .equals(email)).toList());
            model.addAttribute("plants", plantService.readPlants().stream()
                    .filter(plant -> plant.getEmailUser()
                            .equals(email)).toList());
//            System.out.println("logged in");
            return "dashboard";
        }else {
            System.out.println("not logged in");
            return "login";
        }


    }

    /**
     * used to refresh the current data on the plant in the dashboard
     * @param httpServletRequest takes the current data from the arduino and checks for errors
     * @param model used to pass on arduinoconfiguration
     * @return addetails.html
     */
    @PostMapping(value = "/plants/adddetails", consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public String demo(HttpServletRequest httpServletRequest,Model model) {
        ServletInputStream inputStream;

        try {
            inputStream = httpServletRequest.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        final List<String> list = new BufferedReader(new InputStreamReader(inputStream))
                .lines().toList();


        int physicalId = Integer.parseInt(list.get(0).substring(0, 3));
        String json = list.get(0).substring(4, list.get(0).length() - 1);
        if (!json.contains("[")) {
            Plant.Details details = gson.fromJson(json, Plant.Details.class);
            plantService.saveReadingsToDB(details, physicalId );// dont know how to retrieve plantId from this, dummy data
            this.plantService.updatePlantData(details, physicalId);
        }

        model.addAttribute("arduinoConfiguration", arduinoService.postMapping(physicalId));


//        System.out.println(physicalId);
//        System.out.println(json);
        this.plantService.readPlants().forEach(System.out::println);
        return "addetails";
    }

//    [[{"humidity":53,"temperature":24.4,"brightness":14.37147,"moisture":1}]]

    //-----add plant controller

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


    /**
     *
     * @param model used to pass remove and loggedInOrNot attributes
     * @return removePlant.html
     */
    @GetMapping("removePlant")
    public String showRemovePlant(Model model) {
        model.addAttribute("remove");
        model.addAttribute("loggedInOrNot",true);
        return "removePlant";
    }

    /**
     * removes the plant from the database
     * @param plantId id of the plant that was selected to be removed
     * @return dashboard.html
     */
    @PostMapping("removePlant")
    public String removePlant(Integer plantId) {
//        Arduino arduino = this.arduinoService.addArduino(arduinoSeries, Integer.parseInt(physicalId));
        this.plantService.removePlant(plantId);
        return "redirect:/plants";
    }
}