package tn.esprit.firstproject.service;

import tn.esprit.firstproject.entities.Agence;

import java.util.List;

public interface IAgenceService {
    Agence addAgence(Agence agence);

    List<Agence> retrieveAllAgences();

    Agence retrieveAgence(Long idAgence);

    Agence updateAgence(Agence agence);

    void removeAgence(Long idAgence);
}
