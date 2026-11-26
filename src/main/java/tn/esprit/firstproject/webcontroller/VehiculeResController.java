package tn.esprit.firstproject.webcontroller;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.firstproject.entities.Vehicule;
import tn.esprit.firstproject.service.IVehiculeService;
import tn.esprit.firstproject.webcontroller.dto.vehiculeDTO;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@Tag(name = "zerzeri yasmine", description = "gestion des vehicules")
@RequestMapping("/vehicules")
@RequiredArgsConstructor
public class VehiculeResController {

    private final IVehiculeService vehiculeService;

    @PostMapping
    public ResponseEntity<vehiculeDTO> createVehicule(@RequestBody Vehicule vehicule) {
        Vehicule createdVehicule = vehiculeService.addVehicule(vehicule);
        return new ResponseEntity<>(vehiculeService.toDTO(createdVehicule), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<vehiculeDTO>> getAllVehicules() {
        return ResponseEntity.ok(vehiculeService.retrieveAllVehicules().stream().map(vehiculeService::toDTO).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<vehiculeDTO> getVehicule(@PathVariable Long id) {
        return ResponseEntity.ok(vehiculeService.toDTO(vehiculeService.retrieveVehicule(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<vehiculeDTO> updateVehicule(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        vehicule.setIdVehicule(id);
        return ResponseEntity.ok(vehiculeService.toDTO(vehiculeService.updateVehicule(vehicule)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicule(@PathVariable Long id) {
        vehiculeService.removeVehicule(id);
        return ResponseEntity.noContent().build();
    }

    // Lie un vehicule existant a une agence existante : PUT /api/vehicules/{idVehicule}/agence/{idAgence}
    @PutMapping("/{idVehicule}/agence/{idAgence}")
    public ResponseEntity<vehiculeDTO> assignVehiculeToAgence(@PathVariable Long idVehicule,
                                                           @PathVariable Long idAgence) {
        return ResponseEntity.ok(vehiculeService.toDTO(vehiculeService.assignVehiculeToAgence(idVehicule, idAgence)));
    }

    // Ajoute un equipement existant a un vehicule existant : PUT /api/vehicules/{idVehicule}/equipement/{idEquipement}
    @PutMapping("/{idVehicule}/equipement/{idEquipement}")
    public ResponseEntity<vehiculeDTO> assignEquipementToVehicule(@PathVariable Long idVehicule,
                                                               @PathVariable Long idEquipement) {
        return ResponseEntity.ok(vehiculeService.toDTO(vehiculeService.assignEquipementToVehicule(idVehicule, idEquipement)));
    }

    // Cree un vehicule + agence + equipements : POST /api/vehicules/agence/{idAgence}/equipements?idEquipements=1&idEquipements=2
    @PostMapping("/agence/{idAgence}/equipements")
    public ResponseEntity<vehiculeDTO> addVehiculeAndAssignEquipementsAndAgence(@PathVariable Long idAgence,
                                                                             @RequestParam List<Long> idEquipements,
                                                                             @RequestBody Vehicule vehicule) {
        Vehicule created = vehiculeService.addVehiculeAndAssignEquipementsAndAgence(idAgence, idEquipements, vehicule);
        return new ResponseEntity<>(vehiculeService.toDTO(created), HttpStatus.CREATED);
    }

    // Retire l'agence d'un vehicule : DELETE /api/vehicules/{idVehicule}/agence
    @DeleteMapping("/{idVehicule}/agence")
    public ResponseEntity<vehiculeDTO> unassignVehiculeFromAgence(@PathVariable Long idVehicule) {
        return ResponseEntity.ok(vehiculeService.toDTO(vehiculeService.unassignVehiculeFromAgence(idVehicule)));
    }

    // Retire un equipement d'un vehicule : DELETE /api/vehicules/{idVehicule}/equipement/{idEquipement}
    @DeleteMapping("/{idVehicule}/equipement/{idEquipement}")
    public ResponseEntity<vehiculeDTO> unassignEquipementFromVehicule(@PathVariable Long idVehicule,
                                                                   @PathVariable Long idEquipement) {
        return ResponseEntity.ok(vehiculeService.toDTO(vehiculeService.unassignEquipementFromVehicule(idVehicule, idEquipement)));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleNotFound(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }


    // Cree un vehicule et l'affecte a une agence : POST /api/vehicules/agence/{idAgence}
    @PostMapping("/agence/{idAgence}")
    public ResponseEntity<vehiculeDTO> addVehiculeAndAssignToAgence(@PathVariable Long idAgence,
                                                                 @RequestBody Vehicule vehicule) {
        Vehicule created = vehiculeService.addVehiculeAndAssignToAgence(idAgence, vehicule);
        return new ResponseEntity<>(vehiculeService.toDTO(created), HttpStatus.CREATED);

    }
}
