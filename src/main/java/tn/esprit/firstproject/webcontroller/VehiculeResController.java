package tn.esprit.firstproject.webcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.firstproject.entities.Vehicule;
import tn.esprit.firstproject.service.IVehiculeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VehiculeResController {

    private final IVehiculeService vehiculeService;

    @PostMapping("/vehicules")
    public ResponseEntity<Vehicule> createVehicule(@RequestBody Vehicule vehicule) {
        Vehicule createdVehicule = vehiculeService.addVehicule(vehicule);
        return new ResponseEntity<>(createdVehicule, HttpStatus.CREATED);
    }

    @GetMapping("/vehicules")
    public ResponseEntity<List<Vehicule>> getAllVehicules() {
        List<Vehicule> vehicules = vehiculeService.retrieveAllVehicules();
        return new ResponseEntity<>(vehicules, HttpStatus.OK);
    }
}
