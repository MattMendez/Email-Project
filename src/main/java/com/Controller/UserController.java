package com.Controller;

import com.DTO.Login;
import com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String startingPoint(Model model){
        model.addAttribute("login", new Login());
        return "index";
    }

    @PostMapping("/login")
    public String userLogin (@ModelAttribute Login login, Model model){
        if(userService.validateUser(login))
            return "main";
        else
            return "wrong-user";
    }
}
