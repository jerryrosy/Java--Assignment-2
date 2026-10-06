import java.util.*;

// Custom exception for invalid product ID
class InvalidProductIdException extends Exception {
    public InvalidProductIdException(String message) {
        super(message);
    }
}

// Custom exception for invalid quantity
class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

// Custom exception for insufficient stock
class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}

// Custom exception for invalid payment amount
class InvalidPaymentAmountException extends Exception {
    public InvalidPaymentAmountException(String message) {
        super(message);
    }
}

// Custom exception for failed payment
class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) {
        super(message);
    }
}

public class ECommerceSystem {

    static String[] productNames = {
        "Laptop",
        "Smartphone",
        "Headphones",
        "Keyboard"
    };

    static double[] prices = {
        55000,
        25000,
        2000,
        1500
    };

    static int[] stock = {
        5,
        10,
        15,
        20
    };

    // Method to display products
    static void displayProducts() {
        System.out.println("\n----- Available Products -----");

        for (int i = 0; i < productNames.length; i++) {
            System.out.println(
                "Product ID: " + (i + 1) +
                " | " + productNames[i] +
                " | Price: Rs." + prices[i] +
                " | Stock: " + stock[i]
            );
        }
    }

    // Method to check product ID
    static void checkProductId(int productId)
            throws InvalidProductIdException {

        if (productId < 1 || productId > productNames.length) {
            throw new InvalidProductIdException(
                "Invalid Product ID! Please select a valid product."
            );
        }
    }

    // Method to check quantity
    static void checkQuantity(int quantity)
            throws InvalidQuantityException {

        if (quantity <= 0) {
            throw new InvalidQuantityException(
                "Invalid quantity! Quantity must be greater than zero."
            );
        }
    }

    // Method to check stock
    static void checkStock(int productId, int quantity)
            throws InsufficientStockException {

        if (quantity > stock[productId - 1]) {
            throw new InsufficientStockException(
                "Insufficient stock! Available stock: "
                + stock[productId - 1]
            );
        }
    }

    // Method to make payment
    static void makePayment(double totalAmount, double payment)
            throws InvalidPaymentAmountException,
                   PaymentFailedException {

        if (payment <= 0) {
            throw new InvalidPaymentAmountException(
                "Invalid payment amount! Amount must be greater than zero."
            );
        }

        if (payment < totalAmount) {
            throw new PaymentFailedException(
                "Payment failed! Insufficient payment amount."
            );
        }

        System.out.println("Payment successful!");
        System.out.println("Amount paid: Rs." + payment);
        System.out.println("Balance returned: Rs."
                + (payment - totalAmount));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double totalAmount = 0;

        System.out.println("=================================");
        System.out.println("     E-COMMERCE SHOPPING SYSTEM");
        System.out.println("=================================");

        try {

            // Display products
            displayProducts();

            // Get product ID
            System.out.print("\nEnter Product ID: ");
            int productId = sc.nextInt();

            checkProductId(productId);

            // Get quantity
            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();

            checkQuantity(quantity);

            // Check stock
            checkStock(productId, quantity);

            // Calculate total
            totalAmount = prices[productId - 1] * quantity;

            // Reduce stock
            stock[productId - 1] -= quantity;

            System.out.println("\n----- Order Details -----");
            System.out.println("Product: "
                    + productNames[productId - 1]);
            System.out.println("Quantity: " + quantity);
            System.out.println("Price per item: Rs."
                    + prices[productId - 1]);
            System.out.println("Total Amount: Rs." + totalAmount);

            // Payment
            System.out.print("\nEnter payment amount: Rs.");
            double payment = sc.nextDouble();

            makePayment(totalAmount, payment);

            System.out.println("\nOrder placed successfully!");
            System.out.println("Thank you for shopping with us!");

        }

        catch (InvalidProductIdException e) {
            System.out.println("\nERROR: " + e.getMessage());

        }

        catch (InvalidQuantityException e) {
            System.out.println("\nERROR: " + e.getMessage());

        }

        catch (InsufficientStockException e) {
            System.out.println("\nERROR: " + e.getMessage());

        }

        catch (InvalidPaymentAmountException e) {
            System.out.println("\nERROR: " + e.getMessage());

        }

        catch (PaymentFailedException e) {
            System.out.println("\nERROR: " + e.getMessage());

        }

        catch (InputMismatchException e) {
            System.out.println(
                "\nERROR: Please enter numbers only."
            );

        }

        finally {
            System.out.println("\nThank you for using the E-Commerce System.");
            sc.close();
        }
    }
}