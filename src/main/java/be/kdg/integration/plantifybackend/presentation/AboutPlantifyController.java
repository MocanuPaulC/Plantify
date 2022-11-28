package be.kdg.integration.plantifybackend.presentation;

import be.kdg.integration.plantifybackend.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * shows aboutPlantify.html, no special functionality since it is a simple hardcoded page
 */
@Controller
public class AboutPlantifyController {
    @GetMapping("/aboutPlantify")
    public String showIndexView(HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("user");
        if (user != null){
            model.addAttribute("loggedInOrNot",true);
        }else {
            model.addAttribute("loggedInOrNot",false);
        }
        return "aboutPlantify";
    }
}
