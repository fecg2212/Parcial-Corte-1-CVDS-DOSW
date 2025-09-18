package edu.dosw.lab.Parcial01.payment;

public class CryptoPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Procesando pago con Criptomonedas por $" + amount);
    }
}
