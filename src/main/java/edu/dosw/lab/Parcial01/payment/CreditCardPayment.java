package edu.dosw.lab.Parcial01.payment;

public class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Procesando pago con Tarjeta de Crédito por $" + amount);
    }
}

