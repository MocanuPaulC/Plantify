package be.kdg.integration.plantifybackend.presentation;

import  be.kdg.integration.plantifybackend.domain.User;
import be.kdg.integration.plantifybackend.presentation.viewModel.LoginViewModel;
import be.kdg.integration.plantifybackend.service.UserService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {
    UserService userService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUserView(Model model){
        model.addAttribute("loginViewModel", new LoginViewModel());
        return "login";
    }

    @PostMapping
    public String checkUser(HttpSession httpSession, @Valid @ModelAttribute("loginViewModel")LoginViewModel
            loginViewModel, BindingResult errors){
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> {
                logger.error(error.toString());
            });
            return "login";
        }

        User userToCheck = new User(loginViewModel.getEmail(), loginViewModel.getPassword());
        if(userService.checkUser(userToCheck)){
            httpSession.setAttribute("user", userToCheck);
            return "redirect:/dashboard";
        }
        else{
            return "redirect:/login?error";
        }
    }
}
