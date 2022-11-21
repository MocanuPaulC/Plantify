package be.kdg.integration.plantifybackend.presentation;

import  be.kdg.integration.plantifybackend.domain.User;
import be.kdg.integration.plantifybackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUserView(Model model){
        return "login";
    }

    @PostMapping
    public String checkUser(HttpSession httpSession, String email, String password){
        User userToCheck = new User(email, password);
        if(userService.checkUser(userToCheck)){
            httpSession.setAttribute("user", userToCheck);
            return "redirect:/dashboard";
        }
        else{
            return "redirect:/login?error";
        }
    }
}
