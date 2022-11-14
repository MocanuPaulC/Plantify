package be.kdg.integration.plantifybackend.presentation;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.PlantType;
import be.kdg.integration.plantifybackend.service.ArduinoService;
import be.kdg.integration.plantifybackend.service.PlantService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


@Controller
public class plantController {
    PlantService plantService;
    Gson gson =new Gson();
    ArduinoService arduinoService;

    @Autowired
    public plantController(PlantService plantService, ArduinoService arduinoService) {
        this.plantService = plantService;
        this.arduinoService=arduinoService;
    }

    @GetMapping("/plants")
    public String showPlantsView(Model model) {
        model.addAttribute("plants", plantService.readPlants());
        return "index";
    }


    @PostMapping("/plants")
    public String refreshData(){
//        plantService.updatePageData();
//        plantService.refreshPlantData();-------------------------------------------
        return "redirect:/plants";
    }

    @GetMapping("plants/addplant")
    public String showAddPlant(Model model){
        model.addAttribute("add","chill");
        return "addplant";
    }
    @PostMapping("plants/addplant")
    public String addPlant(String name, String plantType, String arduinoSeries, int physicalIdentifier){
      Arduino arduino= this.arduinoService.addArduino(arduinoSeries,physicalIdentifier);
        this.plantService.addPlant(name, PlantType.PLAIN,arduino);
        return "redirect:/plants";
    }

    @PostMapping(value="/plants/adddetails",consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public String demo(HttpServletRequest httpServletRequest) {

        ServletInputStream inputStream;

        try {
            inputStream = httpServletRequest.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        final List<String> list = new BufferedReader(new InputStreamReader(inputStream))
                .lines().toList();


        int physicalId=Integer.parseInt(list.get(0).substring(0,3));
        String json=list.get(0).substring(4,list.get(0).length()-1);
        if(!json.contains("[")) {
            Plant.Details details = gson.fromJson(json, Plant.Details.class);
            this.plantService.updatePlantData(details, physicalId);
        }
        return "adddetails";
    }

//    [[{"humidity":53,"temperature":24.4,"brightness":14.37147,"moisture":1}]]


}

