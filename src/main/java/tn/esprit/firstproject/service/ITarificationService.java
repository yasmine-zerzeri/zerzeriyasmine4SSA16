package tn.esprit.firstproject.service;

import tn.esprit.firstproject.entities.Reservation;

public interface ITarificationService {
    double calculerMontant(Reservation reservation, String codePromo);
}


