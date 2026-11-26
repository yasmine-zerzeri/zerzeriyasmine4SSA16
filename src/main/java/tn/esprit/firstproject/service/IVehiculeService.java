package tn.esprit.firstproject.service;

import tn.esprit.firstproject.entities.Vehicule;
import tn.esprit.firstproject.webcontroller.dto.vehiculeDTO;

import java.util.List;

public interface IVehiculeService {
    Vehicule addVehicule(Vehicule vehicule);
    List<Vehicule> retrieveAllVehicules();
    Vehicule retrieveVehicule(Long idVehicule);

    Vehicule updateVehicule(Vehicule vehicule);

    void removeVehicule(Long idVehicule);

    // Lie un vehicule existant a une agence existante
    Vehicule assignVehiculeToAgence(Long idVehicule, Long idAgence);

    // Ajoute un equipement existant a un vehicule existant
    Vehicule assignEquipementToVehicule(Long idVehicule, Long idEquipement);

    // Cree un nouveau vehicule et le rattache directement a une agence existante
    Vehicule addVehiculeAndAssignToAgence(Long idAgence, Vehicule vehicule);

    // Cree un vehicule, le rattache a une agence existante et lui affecte des equipements existants
    Vehicule addVehiculeAndAssignEquipementsAndAgence(Long idAgence, List<Long> idEquipements, Vehicule vehicule);

    // Retire l'agence d'un vehicule (agence_id = NULL)
    Vehicule unassignVehiculeFromAgence(Long idVehicule);

    // Retire un equipement d'un vehicule (supprime la ligne de vehicule_equipement, l'equipement reste en base)
    Vehicule unassignEquipementFromVehicule(Long idVehicule, Long idEquipement);

    // Convertit un vehicule en DTO (delegue a MapStruct)
    vehiculeDTO toDTO(Vehicule vehicule);

    //vehiculeDTO toDTO(Vehicule vehicule);
}
