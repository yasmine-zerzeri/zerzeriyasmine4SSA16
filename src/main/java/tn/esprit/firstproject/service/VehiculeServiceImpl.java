package tn.esprit.firstproject.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.firstproject.entities.Agence;
import tn.esprit.firstproject.entities.Equipement;
import tn.esprit.firstproject.entities.Vehicule;
import tn.esprit.firstproject.repository.IAgenceRepository;
import tn.esprit.firstproject.repository.IEquipementRepository;
import tn.esprit.firstproject.repository.IVehiculeRepository;
import tn.esprit.firstproject.webcontroller.dto.vehiculeDTO;
import tn.esprit.firstproject.webcontroller.mapper.VehiculeMapper;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final IVehiculeRepository vehiculeRepository;
    private final IAgenceRepository agenceRepository;
    private final IEquipementRepository equipementRepository;
    private final VehiculeMapper vehiculeMapper;




    public vehiculeDTO getVehiculeDTO(Long idVehicule) {
        Vehicule vehicule = retrieveVehicule(idVehicule);
        return vehiculeMapper.toDTO(vehicule);
    }
    @Override
    public Vehicule addVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> retrieveAllVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule retrieveVehicule(Long idVehicule) {
        return vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Vehicule introuvable : " + idVehicule));
    }

    @Override
    public Vehicule updateVehicule(Vehicule vehicule) {
        if (vehicule.getIdVehicule() == null || !vehiculeRepository.existsById(vehicule.getIdVehicule())) {
            throw new EntityNotFoundException("Vehicule introuvable : " + vehicule.getIdVehicule());
        }
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void removeVehicule(Long idVehicule) {
        vehiculeRepository.deleteById(idVehicule);
    }

    @Override
    public Vehicule assignVehiculeToAgence(Long idVehicule, Long idAgence) {
        Vehicule vehicule = retrieveVehicule(idVehicule);
        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable : " + idAgence));
        vehicule.setAgence(agence);
        return vehiculeRepository.save(vehicule);
    }

    @Override
    @Transactional
    public Vehicule assignEquipementToVehicule(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = retrieveVehicule(idVehicule);
        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new EntityNotFoundException("Equipement introuvable : " + idEquipement));

        if (vehicule.getEquipements() == null) {
            vehicule.setEquipements(new HashSet<>());
        }
        vehicule.getEquipements().add(equipement);   // Set : pas de doublon
        return vehiculeRepository.save(vehicule);
    }

    @Override
    @Transactional   // les equipements charges restent "managed" : evite "detached entity passed to persist" (cascade PERSIST)
    public Vehicule addVehiculeAndAssignEquipementsAndAgence(Long idAgence, List<Long> idEquipements, Vehicule vehicule) {
        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable : " + idAgence));

        Set<Equipement> equipements = new HashSet<>();
        for (Long idEquipement : idEquipements) {
            Equipement equipement = equipementRepository.findById(idEquipement)
                    .orElseThrow(() -> new EntityNotFoundException("Equipement introuvable : " + idEquipement));
            equipements.add(equipement);
        }

        vehicule.setAgence(agence);
        vehicule.setEquipements(equipements);
        return vehiculeRepository.save(vehicule);
    }

    // Cree un nouveau vehicule et le rattache directement a une agence existante
    @Override
    public Vehicule addVehiculeAndAssignToAgence(Long idAgence, Vehicule vehicule) {
        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable : " + idAgence));
        vehicule.setAgence(agence);
        return vehiculeRepository.save(vehicule);
    }


    @Override
    public Vehicule unassignVehiculeFromAgence(Long idVehicule) {
        Vehicule vehicule = retrieveVehicule(idVehicule);
        vehicule.setAgence(null);
        return vehiculeRepository.save(vehicule);
    }

    @Override
    @Transactional
    public Vehicule unassignEquipementFromVehicule(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = retrieveVehicule(idVehicule);
        boolean removed = vehicule.getEquipements() != null
                && vehicule.getEquipements().removeIf(e -> e.getIdEquipement().equals(idEquipement));
        if (!removed) {
            throw new EntityNotFoundException("Equipement " + idEquipement + " non affecte au vehicule " + idVehicule);
        }
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public vehiculeDTO toDTO(Vehicule vehicule) {
        return vehiculeMapper.toDTO(vehicule);
    }
/*
    @Override
    public vehiculeDTO toDTO(Vehicule vehicule) {
        vehiculeDTO dto = new vehiculeDTO();
*        dto.setMarque(vehicule.getMarque());
        dto.setModele(vehicule.getModele());
        dto.setCategorie(vehicule.getCategorie());
        dto.setTarifJournalier(vehicule.getTarifJournalier());
        if (vehicule.getAgence() != null) {
            dto.setAgenceId(vehicule.getAgence().getIdAgence());
        }
        return dto;
    }
    */
}
