package tn.esprit.firstproject.service;

import tn.esprit.firstproject.entities.Vehicule;

import java.util.List;

public interface IVehiculeService {

    Vehicule addVehicule(Vehicule vehicule);

    List<Vehicule> retrieveAllVehicules();

    Vehicule retrieveVehicule(Long idVehicule);

    Vehicule updateVehicule(Vehicule vehicule);

    void removeVehicule(Long idVehicule);
}
