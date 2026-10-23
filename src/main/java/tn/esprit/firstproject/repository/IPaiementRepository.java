package tn.esprit.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.firstproject.entities.Paiement;

public interface IPaiementRepository extends JpaRepository<Paiement, Long> {
}
