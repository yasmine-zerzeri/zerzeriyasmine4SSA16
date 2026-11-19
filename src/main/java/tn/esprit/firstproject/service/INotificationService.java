package tn.esprit.firstproject.service;

import tn.esprit.firstproject.entities.Client;

public interface INotificationService {
    void notifier(Client client, String canal, String message);
}
