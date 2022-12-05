package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;


public class ClientRepositoryImplementation {

    @Autowired
    JdbcTemplate jdbcTemplate;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ClientRepositoryImplementation() {
    }


    public Client saveClient(Client client) {
        logger.debug("saving client to database");
        String insertUser=String.format("INSERT INTO client (email, password) " +
                "VALUES ('%s', '%s')", client.getEmail(), client.getPassword());
        jdbcTemplate.execute(insertUser);

        return client;
    }


    public Client searchClient(String email) {
        String searchUser=String.format("SELECT password FROM client WHERE email='%s'", email);
        String password=jdbcTemplate.queryForObject(searchUser, String.class);
        return new Client(email, password);
    }


    public void deleteClient(Client client){
        logger.debug("deleting client");
        String deleteUserSql="DELETE FROM client WHERE email='"+ client.getEmail()+"'; ";
        jdbcTemplate.execute(deleteUserSql);
        logger.debug("deletion successful");
    }
}
