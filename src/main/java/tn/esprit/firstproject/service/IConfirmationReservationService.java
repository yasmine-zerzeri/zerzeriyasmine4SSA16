package tn.esprit.firstproject.service;

import tn.esprit.firstproject.entities.Contrat;
import tn.esprit.firstproject.entities.ModePaiement;

// Orchestre la confirmation d'une reservation
public interface IConfirmationReservationService {
    Contrat confirmer(Long reservationId, ModePaiement mode, String codePromo, String canal);
}
