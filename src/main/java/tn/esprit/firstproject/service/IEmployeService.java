package tn.esprit.firstproject.service;

import tn.esprit.firstproject.entities.Employe;

import java.util.List;

public interface IEmployeService {
    Employe addEmploye(Employe employe);

    List<Employe> retrieveAllEmployes();

    Employe retrieveEmploye(Long idEmploye);

    Employe updateEmploye(Employe employe);

    void removeEmploye(Long idEmploye);
}
