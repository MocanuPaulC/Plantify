package be.kdg.integration.plantifybackend.service;


import be.kdg.integration.plantifybackend.domain.Client;
import be.kdg.integration.plantifybackend.domain.hibernate.ClientDao;
import be.kdg.integration.plantifybackend.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * service class for handling user data
 */
@Component
public class ClientServiceImplementation implements ClientService {
    private ClientRepository clientRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ClientServiceImplementation(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    private Client daoToClient(ClientDao clientDao){
        return new Client(clientDao.getEmail(), clientDao.getPassword());
    }

    /**
     * adds a user to the database, used on signups
     * @param email email of the user
     * @param password password of the user
     * @return function from the repository
     */
    @Override
    public Client addClient(String email, String password) {
        ClientDao clientDao = new ClientDao(email, password);
        clientRepository.save(clientDao);
        return daoToClient(clientDao);
    }

    /**
     * checks if a user exists
     * @param client user that needs to be checked
     * @return boolean if password of the user is correct
     */
    @Override
    public boolean checkClient(Client client) {
        boolean isCorrectPassword=false;
        if(clientRepository.findById(client.getEmail()).isPresent()){
            Client clientChecked = daoToClient(clientRepository.findById(client.getEmail()).get());
            isCorrectPassword= client.getPassword().equals(clientChecked.getPassword());
        }
        else{
            logger.debug(client.getEmail()+" does not exist in a user");
        }

        return isCorrectPassword;
    }

    @Override
    public void removeClient(Client client){
        if(clientRepository.findById(client.getEmail()).isPresent()){
            clientRepository.delete(clientRepository.findById(client.getEmail()).get());
        }
        else{
            logger.debug(client.getEmail()+" does not exist in a user");
        }
    }
}
