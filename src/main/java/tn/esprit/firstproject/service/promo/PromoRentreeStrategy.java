package tn.esprit.firstproject.service.promo;

import org.springframework.stereotype.Component;

@Component
public class PromoRentreeStrategy implements ICodePromoStrategy {

    @Override
    public boolean supports(String codePromo) {
        return "RENTREE".equalsIgnoreCase(codePromo);
    }

    @Override
    public double apply(double amount) {
        return amount * 0.85;
    }
}

