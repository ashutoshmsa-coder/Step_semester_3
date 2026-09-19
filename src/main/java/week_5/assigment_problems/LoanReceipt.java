package week_5.assigment_problems;

import java.util.Arrays;

public class LoanReceipt {

    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = Arrays.copyOf(bookIds, bookIds.length);
    }

    public String[] getBookIds() {
        return Arrays.copyOf(bookIds, bookIds.length);
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] correctedIds = getBookIds();
        correctedIds[index] = newId;

        return new LoanReceipt(memberId, correctedIds);
    }

    public String getMemberId() {
        return memberId;
    }

    static String processNightlyCirculation(LoanReceipt[] receipts) {

        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        for (LoanReceipt receipt : receipts) {

            if (receipt == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (receipt instanceof ReferenceOnlyLoanReceipt) {
                referenceOnly++;
            } else {
                regular++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + referenceOnly + " reference-only | "
                + regular + " regular";
    }

    public static void main(String[] args) {

        String[] books = {"BK-100", "BK-101"};

        LoanReceipt r =
                new LoanReceipt("LIB-8841", books);

        books[0] = "HACKED";

        System.out.println(
                "Original first book: "
                        + r.getBookIds()[0]
        );

        String[] ids = r.getBookIds();
        ids[0] = "CHANGED";

        System.out.println(
                "After getter modification: "
                        + r.getBookIds()[0]
        );

        LoanReceipt corrected =
                r.withCorrectedBookId(1, "BK-102");

        System.out.println(
                "Original books: "
                        + Arrays.toString(r.getBookIds())
        );

        System.out.println(
                "Corrected books: "
                        + Arrays.toString(corrected.getBookIds())
        );

        LoanReceipt[] receipts = {
                new ReferenceOnlyLoanReceipt(
                        "LIB-001",
                        new String[]{"BK-200"},
                        "Reading Room 3"
                ),
                null,
                new LoanReceipt(
                        "LIB-002",
                        new String[]{"BK-201"}
                )
        };

        System.out.println(
                LoanReceipt.processNightlyCirculation(receipts)
        );
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {

    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(
            String memberId,
            String[] bookIds,
            String roomNumber) {

        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}