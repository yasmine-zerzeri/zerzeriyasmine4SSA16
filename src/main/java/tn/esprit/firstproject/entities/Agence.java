package tn.esprit.firstproject.entities;

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
    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
    private Set<Employe> employes;

    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
    private Set<Vehicule> vehicules;
}