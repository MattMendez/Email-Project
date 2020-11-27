package com.Controller;

import com.DTO.Login;
import com.DTO.NewEmail;
import com.Service.EmailService;
import com.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;
    private final EmailService emailService;

    public UserController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @GetMapping("/")
    public String startingPoint(Model model){
        model.addAttribute("login", new Login());
        return "index";
    }

    @PostMapping("/login")
    public String userLogin (@ModelAttribute Login login, Model model){

        return  userService.validateUser(login, model);
    }

    @GetMapping("/register")
    public String userRegister (Model model){
        return "register";
    }

    @GetMapping("/new-email")
    public String newEmail(NewEmail newEmail, Model model){
        model.addAttribute("newEmail",newEmail);
        return "new-email";
    }

    @PostMapping("/new-email")
    public String sendNewEmail(@ModelAttribute NewEmail newEmail, Model model){
        emailService.saveEmail(newEmail);
        model.addAttribute("emails",emailService.allEmails(newEmail.getFrom()));
        return "home";
    }
}
