package be.kdg.integration.plantifybackend.presentation;

import be.kdg.integration.plantifybackend.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/plantlist")
public class PlantListIndex {
    @GetMapping("/plantlist")
    public String showPlantView(Model model) {
        return "plantlist";
    }
}
