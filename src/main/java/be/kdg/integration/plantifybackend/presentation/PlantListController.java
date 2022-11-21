package be.kdg.integration.plantifybackend.presentation;

import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.service.ArduinoService;
import be.kdg.integration.plantifybackend.service.PlantService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/plantList")
    public String showIndexView(Model model) {
        model.addAttribute("plants", plantService.readPlants());
        return "plantList";
    }
    @GetMapping("plantList/{id}")
    public String showPlantSpecific(@PathVariable String id, Model model){
        System.out.println("string id  " + id);
        System.out.println("id " + Integer.parseInt(id));
        Plant plant = new Plant();
        //------------DONT DELETE THIS -- IF DELETED THE PAGE WILL NOT RECEIVE CORRECT DATA---------
        for (Plant readplant :
                plantService.readPlants()) {
            if (readplant.getId() == Integer.parseInt(id)){
                plant = readplant;
                break;
            }
        }
        //--------------------------------------------------------------------------
        model.addAttribute("specPlant",plant);
        model.addAttribute("id",id);
        return "specificPlant";
    }
}
