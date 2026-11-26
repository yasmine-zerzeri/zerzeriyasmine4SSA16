package tn.esprit.firstproject.service;

import tn.esprit.firstproject.entities.Equipement;

import java.util.List;

public interface IEquipementService {
    Equipement addEquipement(Equipement equipement);

    List<Equipement> retrieveAllEquipements();

    Equipement retrieveEquipement(Long idEquipement);

    Equipement updateEquipement(Equipement equipement);

    void removeEquipement(Long idEquipement);
}
