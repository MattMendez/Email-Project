package Controller;

import DTO.Login;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String startingPoint(Model model){
        return "test";
    }

    @PostMapping("/login")
    public String userLogin (@ModelAttribute Login login, Model model){
        if(userService.validateUser(login))
            return "main";
        else
            return "wrong-user";
    }
}
