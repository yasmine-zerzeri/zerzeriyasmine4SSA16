package tn.esprit.firstproject.service.promo;

public interface ICodePromoStrategy {
    boolean supports(String codePromo);

    double apply(double amount);
}
