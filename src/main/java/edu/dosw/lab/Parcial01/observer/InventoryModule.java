package edu.dosw.lab.Parcial01.observer;

public class InventoryModule implements PaymentObserver {
    @Override
    public void update() {
        System.out.println("Inventario actualizado: producto descontado.");
    }
}

