package edu.dosw.lab.Parcial01.payment;

public interface PaymentFactory {
    Payment createPayment();
    PaymentValidator createValidator();
}

