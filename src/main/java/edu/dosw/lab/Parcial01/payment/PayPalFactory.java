package edu.dosw.lab.Parcial01.payment;

public class PayPalFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new PayPalPayment();
    }

    @Override
    public PaymentValidator createValidator() {
        return new PayPalValidator();
    }
}

