package com.Service;

import com.DTO.Login;
import com.Model.User;
import com.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final EmailService emailService;

    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public String validateUser(Login login, Model model) {
        if (login.getPassword().isBlank() || login.getEmail().isBlank())
            return "empty-field";
        Optional <User> user = Optional.ofNullable(userRepository.findByEmail(login.getEmail()).orElse(User.builder().password("").build()));
        if (user.get().getPassword().equals(login.getPassword())){
            model.addAttribute("emails",emailService.allEmails(login.getEmail()));
            return "home";
        } else
            return "wrong-user";
    }
}
