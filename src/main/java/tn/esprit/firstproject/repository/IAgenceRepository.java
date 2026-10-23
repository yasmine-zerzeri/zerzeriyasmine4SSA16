package tn.esprit.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.firstproject.entities.Agence;

public interface IAgenceRepository extends JpaRepository<Agence, Long> {
}
