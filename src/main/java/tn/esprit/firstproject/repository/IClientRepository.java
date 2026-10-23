package tn.esprit.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.firstproject.entities.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {
}
