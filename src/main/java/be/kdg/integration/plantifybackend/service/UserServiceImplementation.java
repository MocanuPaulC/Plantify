package be.kdg.integration.plantifybackend.service;


import be.kdg.integration.plantifybackend.domain.User;
import be.kdg.integration.plantifybackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * service class for handling user data
 */
@Component
public class UserServiceImplementation implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * adds a user to the database, used on signups
     * @param email email of the user
     * @param password password of the user
     * @return function from the repository
     */
    @Override
    public User addUser(String email, String password) {
        return userRepository.saveUser(new User(email, password));
    }

    /**
     * checks if a user exists
     * @param user user that needs to be checked
     * @return boolean if password of the user is correct
     */
    @Override
    public boolean checkUser(User user) {
        User userChecked = userRepository.searchUser(user.getEmail());
        return user.getPassword().equals(userChecked.getPassword());
    }

    @Override
    public void removeUser(User user){
        userRepository.deleteUser(user);
    }
}
