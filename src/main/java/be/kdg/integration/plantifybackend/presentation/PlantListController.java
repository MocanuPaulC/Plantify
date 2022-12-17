package be.kdg.integration.plantifybackend.presentation;

import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.Client;
import be.kdg.integration.plantifybackend.domain.hibernate.ArchiveDao;
import be.kdg.integration.plantifybackend.presentation.viewModel.PlantSpecificViewModel;
import be.kdg.integration.plantifybackend.service.ArduinoService;
import be.kdg.integration.plantifybackend.service.PlantService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for plantlist.html
 */
@Controller
public class PlantListController {

    PlantService plantService;
    Gson gson = new Gson();
    ArduinoService arduinoService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


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
        Client client = (Client) httpSession.getAttribute("user");
        if (client != null) {
            String email= ((Client)httpSession.getAttribute("user")).getEmail();
            model.addAttribute("loggedInOrNot",true);
//            System.out.println(email);
//            System.out.println(plantService.readPlants().stream()
//                    .filter(plant -> plant.getEmailUser()
//                            .equals(email)).toList());
//            List<Double> avgTemp= plantService.readPlants().stream()
//                    .filter(plant -> plant.getId()==id)
//                    .map(plant -> plant.getDetails().getTemperature()).toList();
            model.addAttribute("plants", plantService.readPlants().stream()
                    .filter(plant -> plant.getEmailUser()
                            .equals(email)).toList());
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
        model.addAttribute("plantSpecificViewModel",new PlantSpecificViewModel());
        Plant plant = new Plant();
        //------------DONT DELETE THIS -- IF DELETED THE PAGE WILL NOT RECEIVE CORRECT DATA---------
        for (Plant readplant :
                plantService.readPlants()) {
            if (readplant.getId() == Integer.parseInt(id)) {
                plant = readplant;
                break;
            }
        }
        Client client = (Client) httpSession.getAttribute("user");
        if (client != null) {
            //--------------------------------------------------------------------------
            model.addAttribute("specPlant", plant);
            model.addAttribute("loggedInOrNot", true);
            model.addAttribute("id", id);
            List<ArchiveDao> archiveDaos = plantService.getArchiveByPlantId(Integer.parseInt(id));

            model.addAttribute("archiveDaos", archiveDaos.toArray());
            return "specificPlant";
        }else {
            return "login";
        }
    }

    @PostMapping("plantList/{id}")
    public String processColorForm(@PathVariable String id, @Valid @ModelAttribute("plantSpecificViewModel")
    PlantSpecificViewModel plantSpecificViewModel, Model model) {
        model.addAttribute("id", id);
        plantSpecificViewModel.hex2Rgb();

        logger.debug(plantSpecificViewModel.getHexadecimal());

        arduinoService.setLedSetting(plantService.getPlantPhysicalIdentifier(Integer.parseInt(id)),true);
        arduinoService.changeColor(plantService.getPlantPhysicalIdentifier(Integer.parseInt(id)),
                (short) plantSpecificViewModel.getRed(),
                (short) plantSpecificViewModel.getGreen(),
                (short) plantSpecificViewModel.getBlue());
        return "redirect:/plantList/{id}";
    }

    @GetMapping("/plantList/remove/{id}")
    public String removePlant(@PathVariable String id, Model model, HttpSession httpSession){
        Client client = (Client) httpSession.getAttribute("user");
        model.addAttribute("loggedInOrNot", true);
        if (client != null) {
            //--------------------------------------------------------------------------
            model.addAttribute("loggedInOrNot", true);
//            model.addAttribute("id", id);
            logger.debug("Remove plant request received");
            this.arduinoService.removeArduino(plantService.readPlants().stream()
                    .filter(plant -> plant.getId()== Integer.parseInt(id)).toList().get(0).getArduino().getPhysicalIdentifier());
            this.plantService.removePlant(Integer.parseInt(id));
            return "redirect:/plantList";
        }else {
            return "login";
        }
    }

}
