package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.sql.RowSet;
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

    @Override
    public void deleteUser(User user){
        String getphysicalIdentifiers="SELECT arduinophysicalidentifier FROM plant " +
                "WHERE useremail='"+user.getEmail()+"'; ";
        SqlRowSet rowSet= jdbcTemplate.queryForRowSet(getphysicalIdentifiers);
        while(rowSet.next()){
            // this deletes the arduinos of every plant user has, loops over results of the rowset
            // this might not work, needs to be tested
            String deleteArduino= "DELETE FROM arduino WHERE physicalIdentifier="+rowSet.getInt(1)+"; ";
            jdbcTemplate.execute(deleteArduino);
        }
        String deleteUserSql="DELETE FROM Users WHERE email='"+user.getEmail()+"'; ";
        jdbcTemplate.execute(deleteUserSql);
        //!!!!!!!!! does not remove plant from plantrepositoryimplementation.plantlist
    }
}
