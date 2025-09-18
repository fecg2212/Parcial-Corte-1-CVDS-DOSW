package edu.dosw.lab.Parcial01.observer;

import java.util.ArrayList;
import java.util.List;

public class PaymentEventManager {
    private List<PaymentObserver> observers = new ArrayList<>();

    public void subscribe(PaymentObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(PaymentObserver observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers() {
        for (PaymentObserver obs : observers) {
            obs.update();
        }
    }
}
