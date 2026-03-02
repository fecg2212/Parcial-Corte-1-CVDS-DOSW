package edu.dosw.lab.Parcial01.payment;

public class CryptoFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new CryptoPayment();
    }

    @Override
    public PaymentValidator createValidator() {
        return new CryptoValidator();
    }
}

