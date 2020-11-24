package Service;

import DTO.Login;
import Model.User;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean validateUser(Login login) {
        Optional <User> user = Optional.ofNullable(userRepository.findByEmail(login.getEmail()).orElse(User.builder().build()));
        return user.get().getPassword().equals(login.getPassword());
    }
}
