package week_8.assigment_problems;

import java.util.ArrayList;
import java.util.List;

interface Seat {
    String getSeatNumber();
    double getPrice();
}

class RegularSeat implements Seat {
    private String seatNumber;

    RegularSeat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public double getPrice() {
        return 150;
    }
}

class PremiumSeat implements Seat {
    private String seatNumber;

    PremiumSeat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public double getPrice() {
        return 250;
    }
}

class ReclinerSeat implements Seat {
    private String seatNumber;

    ReclinerSeat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public double getPrice() {
        return 400;
    }
}

class Customer {
    private String name;

    Customer(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

class Show {
    private String showName;
    private boolean started;
    private List<Seat> bookedSeats = new ArrayList<>();

    Show(String showName) {
        this.showName = showName;
        this.started = false;
    }

    boolean isSeatAvailable(Seat seat) {
        return !bookedSeats.contains(seat);
    }

    boolean isSeatNumberBooked(String seatNumber) {
        for (Seat seat : bookedSeats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                return true;
            }
        }
        return false;
    }

    boolean bookSeat(Seat seat) {
        if (isSeatNumberBooked(seat.getSeatNumber())) {
            return false;
        }

        bookedSeats.add(seat);
        return true;
    }

    void releaseSeat(Seat seat) {
        bookedSeats.removeIf(
            bookedSeat ->
                bookedSeat.getSeatNumber()
                    .equals(seat.getSeatNumber())
        );
    }

    void startShow() {
        started = true;
    }

    boolean hasStarted() {
        return started;
    }

    String getShowName() {
        return showName;
    }
}

class Booking {
    private Customer customer;
    private Show show;
    private List<Seat> seats;
    private boolean cancelled;

    Booking(Customer customer, Show show) {
        this.customer = customer;
        this.show = show;
        this.seats = new ArrayList<>();
        this.cancelled = false;
    }

    void addSeat(Seat seat) {

        if (seats.size() >= 6) {
            System.out.println(
                "Cannot book more than 6 seats."
            );
            return;
        }

        if (!show.bookSeat(seat)) {
            System.out.println(
                "Seat " +
                seat.getSeatNumber() +
                " is already booked for this show."
            );
            return;
        }

        seats.add(seat);
    }

    void confirmBooking() {

        if (seats.isEmpty()) {
            System.out.println(
                "Booking cannot be confirmed without seats."
            );
            return;
        }

        System.out.print(
            "Booking confirmed for " +
            customer.getName() +
            ": "
        );

        for (int i = 0; i < seats.size(); i++) {
            System.out.print(
                seats.get(i).getSeatNumber()
            );

            if (i < seats.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.printf(
            ". Total: ₹%.2f%n",
            calculateTotal()
        );
    }

    double calculateTotal() {

        double total = 0;

        for (Seat seat : seats) {
            total += seat.getPrice();
        }

        return total;
    }

    void cancel() {

        if (show.hasStarted()) {
            System.out.println(
                "Cannot cancel booking after the show has started."
            );
            return;
        }

        if (cancelled) {
            System.out.println(
                "Booking is already cancelled."
            );
            return;
        }

        for (Seat seat : seats) {
            show.releaseSeat(seat);
        }

        cancelled = true;

        System.out.println(
            customer.getName() +
            "'s booking cancelled."
        );

        System.out.print("Seats ");

        for (int i = 0; i < seats.size(); i++) {
            System.out.print(
                seats.get(i).getSeatNumber()
            );

            if (i < seats.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println(" released.");
    }
}

public class CampusPremiereTicketCounter {

    public static void main(String[] args) {

        Customer asha =
            new Customer("Asha");

        Customer ravi =
            new Customer("Ravi");

        Customer neha =
            new Customer("Neha");

        Show show =
            new Show("7 PM Show");

        Seat a1 =
            new RegularSeat("A1");

        Seat a2 =
            new RegularSeat("A2");

        Seat f5 =
            new PremiumSeat("F5");

        Seat r1 =
            new ReclinerSeat("R1");

        // Asha books A1, A2 and F5
        Booking ashaBooking =
            new Booking(asha, show);

        ashaBooking.addSeat(a1);
        ashaBooking.addSeat(a2);
        ashaBooking.addSeat(f5);

        ashaBooking.confirmBooking();

        // Ravi attempts to book A2
        Booking raviBooking =
            new Booking(ravi, show);

        raviBooking.addSeat(a2);

        // Ravi books R1
        raviBooking.addSeat(r1);
        raviBooking.confirmBooking();

        // Asha cancels before show starts
        ashaBooking.cancel();

        // Neha books released A2
        Booking nehaBooking =
            new Booking(neha, show);

        nehaBooking.addSeat(a2);
        nehaBooking.confirmBooking();
    }
}