package edu.dosw.lab.Parcial01.payment;

public class PayPalPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Procesando pago con PayPal por $" + amount);
    }
}

