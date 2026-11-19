package tn.esprit.firstproject.service.promo;

import org.springframework.stereotype.Component;

@Component
public class PromoBienvenueStrategy implements ICodePromoStrategy {
    @Override
    public boolean supports(String codePromo) {
        return "BIENVENUE".equalsIgnoreCase(codePromo);
    }
    @Override
    public double apply(double amount) {
        return Math.max(0, amount - 20.0);
    }
}
