package tn.esprit.firstproject.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    private String nom;
    private String ville;
    private String adresse;
    private String telephone;

    @JsonManagedReference("agence-employes")
    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
    private Set<Employe> employes;

    @JsonManagedReference("agence-vehicules")
    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
    private Set<Vehicule> vehicules;
}
