package week_8.class_problems;

abstract class Room {
    String roomNumber;
    boolean available = true;

    Room(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    abstract double calculatePrice(int nights);

    boolean isAvailable() {
        return available;
    }

    void book() {
        available = false;
    }

    void cancel() {
        available = true;
    }
}

class StandardRoom extends Room {

    StandardRoom(String roomNumber) {
        super(roomNumber);
    }

    @Override
    double calculatePrice(int nights) {
        return nights * 100;
    }
}

class DeluxeRoom extends Room {

    DeluxeRoom(String roomNumber) {
        super(roomNumber);
    }

    @Override
    double calculatePrice(int nights) {
        return nights * 150;
    }
}

class SuiteRoom extends Room {

    SuiteRoom(String roomNumber) {
        super(roomNumber);
    }

    @Override
    double calculatePrice(int nights) {
        return nights * 250;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Reservation {
    Customer customer;
    Room room;
    int nights;
    boolean active;

    Reservation(Customer customer, Room room, int nights) {
        this.customer = customer;
        this.room = room;
        this.nights = nights;
        this.active = false;
    }

    void bookRoom() {
        if (!room.isAvailable()) {
            System.out.println(
                "Room " + room.roomNumber + " is not available."
            );
            return;
        }

        room.book();
        active = true;

        double price = room.calculatePrice(nights);

        System.out.println(
            "Room " + room.roomNumber +
            " booked successfully for " +
            customer.name
        );

        System.out.println(
            "Total price: $" + price
        );
    }

    void cancelReservation() {
        if (!active) {
            System.out.println("Reservation is not active.");
            return;
        }

        room.cancel();
        active = false;

        System.out.println(
            "Reservation for " +
            customer.name +
            " cancelled."
        );
    }
}

public class HotelBookingSystem {

    public static void main(String[] args) {

        Customer customer1 = new Customer("Customer 1");
        Customer customer2 = new Customer("Customer 2");

        Room standardRoom = new StandardRoom("Room 101");
        Room deluxeRoom = new DeluxeRoom("Room 202");

        Reservation reservation1 =
            new Reservation(customer1, standardRoom, 3);

        Reservation reservation2 =
            new Reservation(customer2, standardRoom, 2);

        reservation1.bookRoom();

        reservation2.bookRoom();

        reservation1.cancelReservation();

        reservation2.bookRoom();
    }
}