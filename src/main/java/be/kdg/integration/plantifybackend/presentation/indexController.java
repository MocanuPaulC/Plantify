package be.kdg.integration.plantifybackend.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
    @GetMapping("/index")
    public String showIndexView(Model model) {
        return "index";
    }

}
