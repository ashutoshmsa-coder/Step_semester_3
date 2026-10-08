package week_8.class_problems;

abstract class Vehicle {
    String name;
    boolean available;

    Vehicle(String name) {
        this.name = name;
        this.available = true;
    }

    abstract double calculateCharge(int days);

    void rent() {
        available = false;
    }

    void returnVehicle() {
        available = true;
    }
}

class Sedan extends Vehicle {

    Sedan(String name) {
        super(name);
    }

    @Override
    double calculateCharge(int days) {
        return days * 50;
    }
}

class SUV extends Vehicle {

    SUV(String name) {
        super(name);
    }

    @Override
    double calculateCharge(int days) {
        return days * 80;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Rental {
    Customer customer;
    Vehicle vehicle;
    int days;

    Rental(Customer customer, Vehicle vehicle, int days) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
    }

    void startRental() {
        if (vehicle.available) {
            vehicle.rent();

            System.out.println(
                vehicle.name + " rented successfully by " + customer.name
            );

            System.out.println(
                "Rental charge: $" + vehicle.calculateCharge(days)
            );
        } else {
            System.out.println(vehicle.name + " is currently unavailable.");
        }
    }

    void returnRental() {
        vehicle.returnVehicle();

        System.out.println(
            vehicle.name + " returned by " + customer.name
        );
    }
}

public class VehicleRentalSystem {

    public static void main(String[] args) {

        Customer customer1 = new Customer("Customer 1");
        Customer customer2 = new Customer("Customer 2");
        Customer customer3 = new Customer("Customer 3");

        Vehicle sedanA = new Sedan("Sedan A");
        Vehicle suvB = new SUV("SUV B");

        Rental rental1 = new Rental(customer1, sedanA, 3);
        rental1.startRental();

        Rental rental2 = new Rental(customer2, sedanA, 2);
        rental2.startRental();

        rental1.returnRental();

        Rental rental3 = new Rental(customer3, suvB, 5);
        rental3.startRental();
    }
}