package tn.esprit.firstproject.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipement;

    private String libelle;

    @ManyToMany(mappedBy = "equipements", fetch = FetchType.LAZY)
    private Set<Vehicule> vehicules;

}