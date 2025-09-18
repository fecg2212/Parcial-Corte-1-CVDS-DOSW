package edu.dosw.lab.Parcial01.observer;

public class NotificationModule implements PaymentObserver {
    @Override
    public void update() {
        System.out.println("Correo de confirmación enviado al cliente.");
    }
}

