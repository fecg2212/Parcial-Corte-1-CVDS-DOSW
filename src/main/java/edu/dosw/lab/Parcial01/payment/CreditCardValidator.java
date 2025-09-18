package edu.dosw.lab.Parcial01.payment;

public class CreditCardValidator implements PaymentValidator {
    @Override
    public boolean validate(String data) {
        System.out.println("Validando tarjeta de crédito...");
        return data != null && data.startsWith("CC");
    }
}

