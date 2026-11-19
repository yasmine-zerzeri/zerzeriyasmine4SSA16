package tn.esprit.firstproject.service;

import tn.esprit.firstproject.entities.ModePaiement;
import tn.esprit.firstproject.entities.Paiement;

// Choisit le bon mode de paiement et paie
public interface IPaiementProcessor {
    Paiement payer(ModePaiement mode, double montant);
}
