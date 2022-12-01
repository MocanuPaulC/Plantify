package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.User;

public interface UserRepository {
    User saveUser(User user);

    User searchUser(String email);

    void deleteUser(User user);

}
