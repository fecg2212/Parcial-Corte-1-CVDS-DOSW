package edu.dosw.lab.Parcial01.payment;

public class CryptoValidator implements PaymentValidator {
    @Override
    public boolean validate(String data) {
        System.out.println("Validando wallet de criptomonedas...");
        return data != null && data.length() > 10;
    }
}

