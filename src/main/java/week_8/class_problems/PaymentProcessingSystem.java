package week_8.class_problems;

import java.util.ArrayList;
import java.util.List;

interface PaymentMethod {
    boolean processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing Credit Card payment...");
        System.out.println("Payment of $" + amount + " successful.");
        return true;
    }
}

class PayPalPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment...");
        System.out.println("Payment of $" + amount + " successful.");
        return true;
    }
}

class BankTransferPayment implements PaymentMethod {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing Bank Transfer payment...");
        System.out.println("Payment of $" + amount + " failed.");
        return false;
    }
}

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Order {
    Customer customer;
    List<Product> products = new ArrayList<>();
    String status = "Pending";

    Order(Customer customer) {
        this.customer = customer;
    }

    void addProduct(Product product) {
        products.add(product);
        System.out.println(product.name + " added to order.");
    }

    double calculateTotal() {
        double total = 0;

        for (Product product : products) {
            total += product.price;
        }

        return total;
    }

    void makePayment(PaymentMethod paymentMethod) {

        if (products.isEmpty()) {
            System.out.println(
                "Payment cannot be processed. Order has no items."
            );
            return;
        }

        double total = calculateTotal();

        System.out.println(
            "Order total: $" + total
        );

        boolean successful =
            paymentMethod.processPayment(total);

        if (successful) {
            status = "Paid";
            System.out.println("Order status: Paid");
        } else {
            status = "Pending";
            System.out.println(
                "Order status: Pending"
            );
        }
    }
}

public class PaymentProcessingSystem {

    public static void main(String[] args) {

        Customer customer =
            new Customer("Customer 1");

        Product laptop =
            new Product("Laptop", 1000);

        Product mouse =
            new Product("Mouse", 50);

        Order order =
            new Order(customer);

        order.addProduct(laptop);
        order.addProduct(mouse);

        System.out.println();

        PaymentMethod creditCard =
            new CreditCardPayment();

        order.makePayment(creditCard);

        System.out.println();

        Order secondOrder =
            new Order(customer);

        secondOrder.addProduct(laptop);

        PaymentMethod bankTransfer =
            new BankTransferPayment();

        secondOrder.makePayment(bankTransfer);
    }
}