package Controller;

import DTO.Login;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String userLogin (Login login, Model model){
        if(userService.validateUser(login))
            return "main";
        else
            return "wrongUser";
    }
}
