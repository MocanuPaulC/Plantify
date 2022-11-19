package be.kdg.integration.plantifybackend.presentation;

import be.kdg.integration.plantifybackend.domain.User;
import be.kdg.integration.plantifybackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/createUser")
public class SignUpController {
    UserService userService;

    @Autowired
    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showSignInView() {
        return "createUser";
    }


    // Make this method using ViewModels
    @PostMapping
    public String signUp(HttpSession httpSession, String email, String username, String password) {
        User user=userService.addUser(email, password);
        httpSession.setAttribute("user", user);
        return "redirect:/dashboard";
    }
}
