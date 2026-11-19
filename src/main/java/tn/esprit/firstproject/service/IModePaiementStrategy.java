package tn.esprit.firstproject.service;

import tn.esprit.firstproject.entities.ModePaiement;
import tn.esprit.firstproject.entities.Paiement;

// Une classe par mode : carte, virement, especes...
public interface IModePaiementStrategy {
    ModePaiement mode();
    Paiement payer(double montant);
}
