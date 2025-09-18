package edu.dosw.lab.Parcial01.payment;

public class PayPalValidator implements PaymentValidator {
    @Override
    public boolean validate(String data) {
        System.out.println("Validando cuenta PayPal...");
        return data != null && data.contains("@");
    }
}

