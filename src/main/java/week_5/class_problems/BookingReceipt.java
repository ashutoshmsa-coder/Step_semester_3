package week_5.class_problems;

import java.util.Arrays;

class BookingReceipt {

    private final String bookingId;
    private final String[] seatNumbers;

    // Constructor
    public BookingReceipt(String bookingId, String[] seatNumbers) {

        this.bookingId = bookingId;

        // Defensive copy
        this.seatNumbers =
                Arrays.copyOf(seatNumbers, seatNumbers.length);
    }

    // Getter with defensive copy
    public String[] getSeatNumbers() {

        return Arrays.copyOf(
                seatNumbers,
                seatNumbers.length
        );
    }

    // Wither method
    public BookingReceipt withUpdatedSeat(
            int index,
            String newSeat) {

        String[] updatedSeats = getSeatNumbers();

        updatedSeats[index] = newSeat;

        return new BookingReceipt(
                bookingId,
                updatedSeats
        );
    }

    public String getBookingId() {
        return bookingId;
    }

    // Nightly settlement
    static String processNightlySettlement(
            BookingReceipt[] receipts) {

        int processed = 0;
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;

        for (BookingReceipt receipt : receipts) {

            // Handle null safely
            if (receipt == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            // instanceof check
            if (receipt instanceof GroupBookingReceipt) {
                groupCount++;
            } else {
                individualCount++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + groupCount + " group | "
                + individualCount + " individual";
    }

    public static void main(String[] args) {

        // Original booking
        String[] seats = {"A1", "A2"};

        BookingReceipt b =
                new BookingReceipt(
                        "CH-1001",
                        seats
                );

        // Try changing original array
        seats[0] = "X";

        System.out.println(
                "Original first seat: "
                        + b.getSeatNumbers()[0]
        );

        // Create updated receipt
        BookingReceipt updated =
                b.withUpdatedSeat(1, "A3");

        System.out.println(
                "Original seats: "
                        + Arrays.toString(
                                b.getSeatNumbers()
                        )
        );

        System.out.println(
                "Updated seats: "
                        + Arrays.toString(
                                updated.getSeatNumbers()
                        )
        );

        // Batch of receipts
        BookingReceipt[] receipts = {

                new GroupBookingReceipt(
                        "CH-2002",
                        new String[]{"B1", "B2"},
                        2
                ),

                null,

                new BookingReceipt(
                        "CH-3003",
                        new String[]{"C1"}
                )
        };

        System.out.println(
                processNightlySettlement(receipts)
        );
    }
}


// Group booking receipt
class GroupBookingReceipt extends BookingReceipt {

    private final int groupSize;

    public GroupBookingReceipt(
            String bookingId,
            String[] seatNumbers,
            int groupSize) {

        super(bookingId, seatNumbers);

        this.groupSize = groupSize;
    }

    public int getGroupSize() {
        return groupSize;
    }
}