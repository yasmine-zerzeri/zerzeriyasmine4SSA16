package tn.esprit.firstproject.webcontroller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.firstproject.entities.Vehicule;
import tn.esprit.firstproject.webcontroller.dto.vehiculeDTO;

@Mapper(componentModel = "spring")
public interface VehiculeMapper {
    @Mapping(source = "idVehicule", target = "idVehicule")
    @Mapping(source = "immatriculation", target = "immatriculation")
    @Mapping(source = "marque", target = "marque")
    @Mapping(source = "categorie", target = "categorie")
    @Mapping(source = "statut", target = "statut")
    @Mapping(source = "agence.nom", target = "nomAgence")
    vehiculeDTO toDTO(Vehicule vehicule);
}
