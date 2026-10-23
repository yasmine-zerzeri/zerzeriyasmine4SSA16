package tn.esprit.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.firstproject.entities.Maintenance;

public interface IMaintenanceRepository extends JpaRepository<Maintenance, Long> {
}
