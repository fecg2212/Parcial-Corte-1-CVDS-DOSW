package edu.dosw.lab.Parcial01;

import edu.dosw.lab.Parcial01.payment.*;
import edu.dosw.lab.Parcial01.observer.*;
import edu.dosw.lab.Parcial01.service.PaymentService;

import java.util.Scanner;

public class Parcial01Application {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== SISTEMA DE PAGOS ===");
		System.out.println("Selecccione el método de pago:");
		System.out.println("1. Tarjeta de Crrdito");
		System.out.println("2. PayPal");
		System.out.println("3. Criptomonedas");
		System.out.print("Opción: ");
		int opcion = scanner.nextInt();
		scanner.nextLine();

		PaymentFactory factory;

		switch (opcion) {
			case 1 -> factory = new CreditCardFactory();
			case 2 -> factory = new PayPalFactory();
			case 3 -> factory = new CryptoFactory();
			default -> {
				System.out.println("❌ Opción inválida.");
				return;
			}
		}

		PaymentService service = new PaymentService(factory);
		service.addObserver(new InventoryModule());
		service.addObserver(new BillingModule());
		service.addObserver(new NotificationModule());

		System.out.print("Ingrese los datos para validar el pago: ");
		String data = scanner.nextLine();

		System.out.print("Ingrese el monto a pagar: ");
		double amount = scanner.nextDouble();

		service.processPayment(data, amount);

		scanner.close();
	}
}


