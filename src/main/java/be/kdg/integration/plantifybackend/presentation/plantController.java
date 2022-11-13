package be.kdg.integration.plantifybackend.presentation;

import be.kdg.integration.plantifybackend.service.PlantService;
import be.kdg.integration.plantifybackend.service.PlantServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


@Controller
public class plantController {
    PlantService plantService;

    @Autowired
    public plantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/plants")
    public String showPlantsView(Model model) {
        model.addAttribute("plants", plantService.readPlants());
        return "index";
    }


    @PostMapping("/plants")
    public String refreshData(){
        plantService.refreshPlantData();
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
        String json=list.get(0).substring(1,list.get(0).length()-1);

        System.out.println(json);

        return "adddetails";
    }

//    [[{"humidity":53,"temperature":24.4,"brightness":14.37147,"moisture":1}]]


}

