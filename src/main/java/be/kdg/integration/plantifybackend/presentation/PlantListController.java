package be.kdg.integration.plantifybackend.presentation;

import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.User;
import be.kdg.integration.plantifybackend.service.ArduinoService;
import be.kdg.integration.plantifybackend.service.PlantService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

/**
 * Controller for plantlist.html
 */
@Controller
public class PlantListController {

    PlantService plantService;
    Gson gson = new Gson();
    ArduinoService arduinoService;


    @Autowired
    public PlantListController(PlantService plantService, ArduinoService arduinoService) {
        this.plantService = plantService;
        this.arduinoService = arduinoService;
    }

    /**
     * shows the details of all plants
     * @param httpSession used to get the user
     * @param model used to pass on loggedInOrNot and plants
     * @return plantlist.html if logged in
     */
    @GetMapping("/plantList")
    public String showIndexView(HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("loggedInOrNot", true);
            model.addAttribute("plants", plantService.readPlants());
            return "plantList";
        } else {
            return "login";
        }

    }

    /**
     * shows details of a singular plant
     * @param id id of the plant selected
     * @param httpSession used to get the user
     * @param model used to pass on loggedInOrNot, the correct plant and plantid
     * @return specificplant.html if logged in
     */
    @GetMapping("plantList/{id}")
    public String showPlantSpecific(@PathVariable String id, HttpSession httpSession, Model model) {
        model.addAttribute("loggedInOrNot", true);
        Plant plant = new Plant();
        //------------DONT DELETE THIS -- IF DELETED THE PAGE WILL NOT RECEIVE CORRECT DATA---------
        for (Plant readplant :
                plantService.readPlants()) {
            if (readplant.getId() == Integer.parseInt(id)) {
                plant = readplant;
                break;
            }
        }
        User user = (User) httpSession.getAttribute("user");
        if (user != null) {
            //--------------------------------------------------------------------------
            model.addAttribute("specPlant", plant);
            model.addAttribute("loggedInOrNot", true);
            model.addAttribute("id", id);
            return "specificPlant";
        }else {
            return "login";
        }
    }
}
