package edu.dosw.lab.Parcial01.payment;

public class CreditCardFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new CreditCardPayment();
    }

    @Override
    public PaymentValidator createValidator() {
        return new CreditCardValidator();
    }
}

