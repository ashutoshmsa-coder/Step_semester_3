package week_3.class_problems;

public class LateFeeAccount {

    String regNo;
    double totalFee;

    public LateFeeAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    // final method - cannot be overridden
    final double calculateLateFee(int daysLate) {
        return daysLate * 2000;
    }

    // final method - cannot be overridden
    final void printSummary(int daysLate) {

        if (daysLate <= 0) {
            System.out.println(regNo + " - On time, no late fee");
            return;
        }

        double lateFee = calculateLateFee(daysLate);

        System.out.println(
            regNo + " | Total Fee: Rs " + totalFee
            + " | Late Fee: Rs " + lateFee
        );
    }

    public static void main(String[] args) {

        String[] regNos = {
            "RA001", "RA002", "RA003", "RA004"
        };

        double[] totalFees = {
            200000, 150000, 180000, 220000
        };

        int[] daysLate = {
            10, 0, -2, 5
        };

        // Process the whole batch in one pass
        for (int i = 0; i < regNos.length; i++) {

            LateFeeAccount account =
                new LateFeeAccount(regNos[i], totalFees[i]);

            account.printSummary(daysLate[i]);
        }
    }
}
