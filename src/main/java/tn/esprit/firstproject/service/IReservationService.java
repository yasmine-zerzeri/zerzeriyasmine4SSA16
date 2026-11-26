package tn.esprit.firstproject.service;

import tn.esprit.firstproject.entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation addReservation(Reservation reservation);

    List<Reservation> retrieveAllReservations();

    Reservation retrieveReservation(Long idReservation);

    Reservation updateReservation(Reservation reservation);

    void removeReservation(Long idReservation);
}
