package week_6.assigment_problems;

public class GymMember {

    private static int memberCounter = 2000;

    private final String membershipNumber;

    private String memberId;
    private int monthlyFee;
    private int sessionsAttended;

    private int[] lateFeeHistory;
    private int lateFeeCount;

    private int feesPaid;

    // Constructor used in Problems 1-4
    public GymMember(String memberId, int monthlyFee) {

        if (memberId == null
                || memberId.trim().isEmpty()
                || memberId.length() < 4) {

            throw new IllegalArgumentException(
                    "Invalid member ID");
        }

        if (monthlyFee <= 0) {
            throw new IllegalArgumentException(
                    "Monthly fee must be positive");
        }

        memberCounter++;
        this.membershipNumber = "GYM-" + memberCounter;

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;

        this.lateFeeHistory = new int[10];
        this.lateFeeCount = 0;

        this.feesPaid = 0;
    }

    // Constructor required for Problem 5
    public GymMember(int monthlyFee) {

        if (monthlyFee <= 0) {
            throw new IllegalArgumentException(
                    "Monthly fee must be positive");
        }

        memberCounter++;
        this.membershipNumber = "GYM-" + memberCounter;

        this.memberId = null;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;

        this.lateFeeHistory = new int[10];
        this.lateFeeCount = 0;

        this.feesPaid = 0;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public String getMemberId() {
        return memberId;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public String displayInfo() {

        return "Standard Member | Sessions: "
                + sessionsAttended;
    }

    public static String signUpBatch(
            String[] memberIds, int monthlyFee) {

        int signedUp = 0;
        int rejected = 0;

        for (String memberId : memberIds) {

            try {
                new GymMember(memberId, monthlyFee);
                signedUp++;

            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Signed Up: " + signedUp
                + " | Rejected: " + rejected;
    }

    protected void chargeLateFee(int amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Late fee must be positive");
        }

        if (lateFeeCount < lateFeeHistory.length) {

            lateFeeHistory[lateFeeCount] = amount;
            lateFeeCount++;
        }
    }

    public int[] getLateFeeHistory() {

        int[] copy = new int[lateFeeCount];

        for (int i = 0; i < lateFeeCount; i++) {
            copy[i] = lateFeeHistory[i];
        }

        return copy;
    }

    public int getTotalLateFees() {

        int total = 0;

        for (int i = 0; i < lateFeeCount; i++) {
            total += lateFeeHistory[i];
        }

        return total;
    }

    public void payFee(int amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Payment must be positive");
        }

        feesPaid += amount;
    }

    public void payFee(int amount, String mode) {

        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public static boolean isValidReferralCode(String code) {

        if (code == null || code.length() != 4) {
            return false;
        }

        if (code.charAt(0) != 'G') {
            return false;
        }

        if (!Character.isDigit(code.charAt(1))) {
            return false;
        }

        if (!Character.isDigit(code.charAt(2))) {
            return false;
        }

        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }

        return true;
    }

    public static int getMembersEnrolled() {
        return memberCounter - 2000;
    }

    public static String processWeeklyCheckIn(
            GymMember[] members) {

        int processed = 0;
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;

        for (GymMember member : members) {

            if (member == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (member instanceof GroupClassMember) {
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
}

    