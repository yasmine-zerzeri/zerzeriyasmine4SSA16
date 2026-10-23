package tn.esprit.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.firstproject.entities.Vehicule;

public interface IVehiculeRepository extends JpaRepository<Vehicule, Long> {
}
