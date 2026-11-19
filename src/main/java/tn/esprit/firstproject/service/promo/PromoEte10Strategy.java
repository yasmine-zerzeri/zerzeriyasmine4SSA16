package tn.esprit.firstproject.service.promo;

import org.springframework.stereotype.Component;

@Component
public class PromoEte10Strategy implements ICodePromoStrategy {
    @Override
    public boolean supports(String codePromo) {
        return "ETE10".equalsIgnoreCase(codePromo);
    }
    @Override
    public double apply(double amount) {
        return amount * 0.90;
    }
}
