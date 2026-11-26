package tn.esprit.firstproject.webcontroller.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import tn.esprit.firstproject.entities.Agence;
import tn.esprit.firstproject.entities.Vehicule;
import tn.esprit.firstproject.webcontroller.dto.vehiculeDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-11-26T12:38:43+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.14 (JetBrains s.r.o.)"
)
@Component
public class VehiculeMapperImpl implements VehiculeMapper {

    @Override
    public vehiculeDTO toDTO(Vehicule vehicule) {
        if ( vehicule == null ) {
            return null;
        }

        vehiculeDTO vehiculeDTO = new vehiculeDTO();

        vehiculeDTO.setIdVehicule( vehicule.getIdVehicule() );
        vehiculeDTO.setImmatriculation( vehicule.getImmatriculation() );
        vehiculeDTO.setMarque( vehicule.getMarque() );
        vehiculeDTO.setCategorie( vehicule.getCategorie() );
        vehiculeDTO.setStatut( vehicule.getStatut() );
        vehiculeDTO.setNomAgence( vehiculeAgenceNom( vehicule ) );

        return vehiculeDTO;
    }

    private String vehiculeAgenceNom(Vehicule vehicule) {
        Agence agence = vehicule.getAgence();
        if ( agence == null ) {
            return null;
        }
        return agence.getNom();
    }
}
