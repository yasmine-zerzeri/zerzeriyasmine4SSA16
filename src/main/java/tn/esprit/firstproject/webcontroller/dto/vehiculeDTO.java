package tn.esprit.firstproject.webcontroller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.firstproject.entities.CategorieVehicule;
import tn.esprit.firstproject.entities.StatutVehicule;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class vehiculeDTO {
    private Long idVehicule;
    private String immatriculation;
    private String marque;
    private CategorieVehicule categorie;
    private StatutVehicule statut;
    private String nomAgence;
}
