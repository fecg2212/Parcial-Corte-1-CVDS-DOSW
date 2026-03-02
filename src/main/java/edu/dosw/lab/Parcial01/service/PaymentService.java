package edu.dosw.lab.Parcial01.service;

import edu.dosw.lab.Parcial01.payment.*;
import edu.dosw.lab.Parcial01.observer.*;

public class PaymentService {
    private PaymentFactory factory;
    private PaymentEventManager eventManager = new PaymentEventManager();

    public PaymentService(PaymentFactory factory) {
        this.factory = factory;
    }

    public void addObserver(PaymentObserver observer) {
        eventManager.subscribe(observer);
    }

    public void processPayment(String data, double amount) {
        PaymentValidator validator = factory.createValidator();
        if (validator.validate(data)) {
            Payment payment = factory.createPayment();
            payment.pay(amount);
            eventManager.notifyAllObservers();
        } else {
            System.out.println("❌ Validación fallid - no se procesó el pago.");
        }
    }
}

