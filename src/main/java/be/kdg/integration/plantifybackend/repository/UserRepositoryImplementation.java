package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

@Repository
public class UserRepositoryImplementation implements UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public UserRepositoryImplementation() {
    //    jdbcTemplate= new JdbcTemplate(springJdbcConfig.mysqlDataSource());
    }

    @Override
    public User saveUser(User user) {
        System.out.println("gets here");
        String insertUser=String.format("INSERT INTO users (email, password) " +
                "VALUES ('%s', '%s')", user.getEmail(), user.getPassword());
        jdbcTemplate.execute(insertUser);
        return user;
    }

    @Override
    public User searchUser(String email) {
        String searchUser=String.format("SELECT password FROM users WHERE email='%s'", email);
        String password=jdbcTemplate.queryForObject(searchUser, String.class);
        return new User(email, password);
    }
}
