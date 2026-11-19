package tn.esprit.firstproject.service;

import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Reservation;
import tn.esprit.firstproject.service.promo.ICodePromoStrategy;

import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Contexte du patron Strategy.
 * Spring injecte TOUTES les implementations de ICodePromoStrategy (@Component).
 * Le service parcourt la liste et delegue a la premiere strategie qui supporte le code.
 */
@Service
public class TarificationServiceImpl implements ITarificationService {

    private final List<ICodePromoStrategy> strategies;

    public TarificationServiceImpl(List<ICodePromoStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public double calculerMontant(Reservation reservation, String codePromo) {
        double montant = calculerTarifBase(reservation);

        if (codePromo != null && !codePromo.isBlank()) {
            for (ICodePromoStrategy strategy : strategies) {
                if (strategy.supports(codePromo.trim())) {
                    return strategy.apply(montant);
                }
            }
        }

        return montant;
    }

    // Tarif journalier x nombre de jours (minimum 1 jour)
    private double calculerTarifBase(Reservation reservation) {
        long jours = Math.max(1, ChronoUnit.DAYS.between(reservation.getDateDebut(), reservation.getDateFin()));
        return reservation.getVehicule().getTarifJournalier().doubleValue() * jours;
    }
}
