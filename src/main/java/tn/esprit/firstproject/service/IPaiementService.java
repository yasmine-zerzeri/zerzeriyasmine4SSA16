package tn.esprit.firstproject.service;

import tn.esprit.firstproject.entities.Paiement;

import java.util.List;

public interface IPaiementService {
    Paiement addPaiement(Paiement paiement);

    List<Paiement> retrieveAllPaiements();

    Paiement retrievePaiement(Long idPaiement);

    Paiement updatePaiement(Paiement paiement);

    void removePaiement(Long idPaiement);
}
