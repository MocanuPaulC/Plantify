package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.Client;

public interface ClientRepository {
    Client saveClient(Client client);

    Client searchClient(String email);

    void deleteClient(Client client);

}
