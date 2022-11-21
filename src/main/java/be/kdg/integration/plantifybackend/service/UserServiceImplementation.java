package be.kdg.integration.plantifybackend.service;


import be.kdg.integration.plantifybackend.domain.User;
import be.kdg.integration.plantifybackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImplementation implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(String email, String password) {
        return userRepository.saveUser(new User(email, password));
    }

    @Override
    public boolean checkUser(User user) {
        User userChecked = userRepository.searchUser(user.getEmail());
        return user.getPassword().equals(userChecked.getPassword());
    }
}
