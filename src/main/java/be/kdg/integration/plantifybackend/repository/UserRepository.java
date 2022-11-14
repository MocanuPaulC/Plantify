package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.User;

public interface UserRepository {
    void saveUser(User user);

    User searchUser(String email);

}
