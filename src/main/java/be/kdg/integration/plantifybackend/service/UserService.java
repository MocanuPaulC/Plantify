package be.kdg.integration.plantifybackend.service;

import be.kdg.integration.plantifybackend.domain.User;

public interface UserService {
    void addUser(String email, String password);

    boolean checkUser(User user);

}
