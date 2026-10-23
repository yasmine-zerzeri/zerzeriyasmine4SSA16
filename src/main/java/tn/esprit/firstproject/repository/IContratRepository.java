package tn.esprit.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.firstproject.entities.Contrat;


public interface IContratRepository extends JpaRepository<Contrat, Long> {
}