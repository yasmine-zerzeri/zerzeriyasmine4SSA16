package tn.esprit.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.firstproject.entities.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {
}
