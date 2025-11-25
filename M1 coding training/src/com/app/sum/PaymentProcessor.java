package com.app.sum;

// custom exception for payment limit
class InsufficientFundsException extends Exception {
    // constructor forwards message
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// processor class for handling payments
public class PaymentProcessor {
    // maximum allowed payment constant
    private static final double MAX_PAYMENT_LIMIT = 1000.0;

    // method to process payment with validation
    public void processPayment(double amount) throws InsufficientFundsException {
        // check if amount exceeds limit
        if (amount > MAX_PAYMENT_LIMIT) {
            throw new InsufficientFundsException(
                "Payment amount exceeds the maximum limit of " + MAX_PAYMENT_LIMIT
            );
        }
    }

    // main method for testing scenarios
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor(); // create processor object

        try {
            processor.processPayment(500.0); // valid payment case
            System.out.println("Payment 1: Successfully processed.");
        } catch (InsufficientFundsException e) {
            System.out.println("Payment 1: Error - " + e.getMessage());
        }

        try {
            processor.processPayment(1200.0); // invalid payment case
            System.out.println("Payment 2: Successfully processed.");
        } catch (InsufficientFundsException e) {
            System.out.println("Payment 2: Error - " + e.getMessage());
        }
    }
}