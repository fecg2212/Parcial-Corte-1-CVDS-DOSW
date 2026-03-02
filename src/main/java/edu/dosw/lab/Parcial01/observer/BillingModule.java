package edu.dosw.lab.Parcial01.observer;

public class BillingModule implements PaymentObserver {
    @Override
    public void update() {
        System.out.println("Factura generada.");
    }
}

