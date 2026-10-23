package tn.esprit.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.firstproject.entities.Equipement;

public interface IEquipementRepository extends JpaRepository<Equipement, Long> {
}
