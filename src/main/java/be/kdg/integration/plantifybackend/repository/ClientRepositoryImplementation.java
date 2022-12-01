package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositoryImplementation implements ClientRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public ClientRepositoryImplementation() {
    //    jdbcTemplate= new JdbcTemplate(springJdbcConfig.mysqlDataSource());
    }

    @Override
    public Client saveClient(Client client) {
        System.out.println("gets here");
        String insertUser=String.format("INSERT INTO client (email, password) " +
                "VALUES ('%s', '%s')", client.getEmail(), client.getPassword());
        jdbcTemplate.execute(insertUser);
        return client;
    }

    @Override
    public Client searchClient(String email) {
        String searchUser=String.format("SELECT password FROM client WHERE email='%s'", email);
        String password=jdbcTemplate.queryForObject(searchUser, String.class);
        return new Client(email, password);
    }

    @Override
    public void deleteClient(Client client){
        String getphysicalIdentifiers="SELECT arduinophysicalidentifier FROM plant " +
                "WHERE useremail='"+ client.getEmail()+"'; ";
//        SqlRowSet rowSet= jdbcTemplate.queryForRowSet(getphysicalIdentifiers);
        // This shouldn't be here
        // This should only delete the client. The deletion of all the arduinos will be made in the arduino class

//        while(rowSet.next()){
//            // this deletes the arduinos of every plant user has, loops over results of the rowset
//            // this might not work, needs to be tested
//            String deleteArduino= "DELETE FROM arduino WHERE physicalIdentifier="+rowSet.getInt(1)+"; ";
//            jdbcTemplate.execute(deleteArduino);
//        }
        String deleteUserSql="DELETE FROM client WHERE email='"+ client.getEmail()+"'; ";
        jdbcTemplate.execute(deleteUserSql);
        //!!!!!!!!! does not remove plant from plantrepositoryimplementation.plantlist
    }
}
