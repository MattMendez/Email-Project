package com.Service;

import com.DTO.Login;
import com.Model.User;
import com.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validateUser(Login login) {
        Optional <User> user = Optional.ofNullable(userRepository.findByEmail(login.getEmail()).orElse(User.builder().build()));
        return user.get().getPassword().equals(login.getPassword());
    }
}
