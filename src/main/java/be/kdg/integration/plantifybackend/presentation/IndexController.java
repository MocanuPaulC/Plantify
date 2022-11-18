package be.kdg.integration.plantifybackend.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String showIndexView(Model model) {
        return "index";
    }
}
