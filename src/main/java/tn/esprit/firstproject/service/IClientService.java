package tn.esprit.firstproject.service;

import tn.esprit.firstproject.entities.Client;

import java.util.List;

public interface IClientService {
    Client addClient(Client client);

    List<Client> retrieveAllClients();

    Client retrieveClient(Long idClient);

    Client updateClient(Client client);

    void removeClient(Long idClient);
}
