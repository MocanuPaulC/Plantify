package be.kdg.integration.plantifybackend.presentation;

import be.kdg.integration.plantifybackend.domain.User;
import be.kdg.integration.plantifybackend.presentation.viewModel.SignUpViewModel;
import be.kdg.integration.plantifybackend.service.UserService;
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
@RequestMapping("/createUser")
public class SignUpController {
    UserService userService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showSignUpView(Model model) {
        model.addAttribute("signUpViewModel", new SignUpViewModel());
        return "createUser";
    }


    // Make this method using ViewModels
    @PostMapping
    public String signUp(HttpSession httpSession, @Valid @ModelAttribute("signUpViewModel") SignUpViewModel
            signUpViewModel, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> {
                logger.error(error.toString());
            });
            return "createUser";
        }
        User user=userService.addUser(signUpViewModel.getEmail(), signUpViewModel.getPassword());
        httpSession.setAttribute("user", user);
        return "redirect:/dashboard";
    }
}
