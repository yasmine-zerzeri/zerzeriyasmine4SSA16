package tn.esprit.firstproject.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String numPermis;
    private LocalDate dateInscription;

    @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
    private Set<Reservation> reservations;
}