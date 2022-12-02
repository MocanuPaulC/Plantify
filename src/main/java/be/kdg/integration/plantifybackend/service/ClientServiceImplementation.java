package be.kdg.integration.plantifybackend.service;


import be.kdg.integration.plantifybackend.domain.Client;
import be.kdg.integration.plantifybackend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * service class for handling user data
 */
@Component
public class ClientServiceImplementation implements ClientService {
    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImplementation(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * adds a user to the database, used on signups
     * @param email email of the user
     * @param password password of the user
     * @return function from the repository
     */
    @Override
    public Client addClient(String email, String password) {
        return clientRepository.saveClient(new Client(email, password));
    }

    /**
     * checks if a user exists
     * @param client user that needs to be checked
     * @return boolean if password of the user is correct
     */
    @Override
    public boolean checkClient(Client client) {
        Client clientChecked = clientRepository.searchClient(client.getEmail());
        return client.getPassword().equals(clientChecked.getPassword());
    }

    @Override
    public void removeClient(Client client){
        clientRepository.deleteClient(client);
    }
}
