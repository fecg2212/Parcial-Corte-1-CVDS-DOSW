package edu.dosw.lab.Parcial01;

import edu.dosw.lab.Parcial01.payment.*;
import edu.dosw.lab.Parcial01.observer.*;
import edu.dosw.lab.Parcial01.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Parcial01ApplicationTests {

	private PaymentService creditCardService;
	private PaymentService paypalService;
	private PaymentService cryptoService;

	@BeforeEach
	void setUp() {
		creditCardService = new PaymentService(new CreditCardFactory());
		paypalService = new PaymentService(new PayPalFactory());
		cryptoService = new PaymentService(new CryptoFactory());

		// agregamos observers
		creditCardService.addObserver(new InventoryModule());
		creditCardService.addObserver(new BillingModule());
		creditCardService.addObserver(new NotificationModule());

		paypalService.addObserver(new InventoryModule());
		paypalService.addObserver(new BillingModule());
		paypalService.addObserver(new NotificationModule());

		cryptoService.addObserver(new InventoryModule());
		cryptoService.addObserver(new BillingModule());
		cryptoService.addObserver(new NotificationModule());
	}

	@Test
	void testCreditCardValidatorValid() {
		PaymentValidator validator = new CreditCardValidator();
		assertTrue(validator.validate("CC12345678901234"));
	}

	@Test
	void testCreditCardValidatorInvalid() {
		PaymentValidator validator = new CreditCardValidator();
		assertFalse(validator.validate("123456789"));
	}

	@Test
	void testPayPalValidatorValid() {
		PaymentValidator validator = new PayPalValidator();
		assertTrue(validator.validate("user@example.com"));
	}

	@Test
	void testPayPalValidatorInvalid() {
		PaymentValidator validator = new PayPalValidator();
		assertFalse(validator.validate("userexample.com"));
	}

	@Test
	void testCryptoValidatorValid() {
		PaymentValidator validator = new CryptoValidator();
		assertTrue(validator.validate("0x1234567890abcdef1234"));
	}

	@Test
	void testCryptoValidatorInvalid() {
		PaymentValidator validator = new CryptoValidator();
		assertFalse(validator.validate("short"));
	}

	@Test
	void testPaymentServiceWithValidCreditCard() {
		assertDoesNotThrow(() -> creditCardService.processPayment("CC12345678901234", 150.0));
	}

	@Test
	void testPaymentServiceWithInvalidCreditCard() {
		assertDoesNotThrow(() -> creditCardService.processPayment("INVALID", 150.0));
	}

	@Test
	void testPaymentServiceWithValidPayPal() {
		assertDoesNotThrow(() -> paypalService.processPayment("valid@mail.com", 200.0));
	}

	@Test
	void testPaymentServiceWithInvalidPayPal() {
		assertDoesNotThrow(() -> paypalService.processPayment("invalidmail.com", 200.0));
	}

	@Test
	void testPaymentServiceWithValidCrypto() {
		assertDoesNotThrow(() -> cryptoService.processPayment("0x9876543210abcdef9876", 300.0));
	}

	@Test
	void testPaymentServiceWithInvalidCrypto() {
		assertDoesNotThrow(() -> cryptoService.processPayment("123", 300.0));
	}

	@Test
	void testObserversAreTriggered() {
		// Probamos que al menos se ejecute el flujo de notificaciones
		PaymentObserver inventory = new InventoryModule();
		PaymentObserver billing = new BillingModule();
		PaymentObserver notification = new NotificationModule();

		inventory.update();
		billing.update();
		notification.update();
	}

	@Test
	void testCreditCardFactoryCreatesObjects() {
		PaymentFactory factory = new CreditCardFactory();
		assertNotNull(factory.createPayment());
		assertNotNull(factory.createValidator());
	}

	@Test
	void testPayPalFactoryCreatesObjects() {
		PaymentFactory factory = new PayPalFactory();
		assertNotNull(factory.createPayment());
		assertNotNull(factory.createValidator());
	}

	@Test
	void testCryptoFactoryCreatesObjects() {
		PaymentFactory factory = new CryptoFactory();
		assertNotNull(factory.createPayment());
		assertNotNull(factory.createValidator());
	}

	@Test
	void testCreditCardValidatorEmptyString() {
		PaymentValidator validator = new CreditCardValidator();
		assertFalse(validator.validate(""));
	}

	@Test
	void testPayPalValidatorEmptyString() {
		PaymentValidator validator = new PayPalValidator();
		assertFalse(validator.validate(""));
	}

	@Test
	void testCryptoValidatorShortString() {
		PaymentValidator validator = new CryptoValidator();
		assertFalse(validator.validate("0x12"));
	}

	@Test
	void testPaymentServiceNoObservers() {
		PaymentService service = new PaymentService(new CreditCardFactory());
		// No agregamos observers
		assertDoesNotThrow(() -> service.processPayment("CC12345678901234", 999.99));
	}
}



