package week_6.assigment_problems;

public class Week6AssignmentProblem5 {

    public static void main(String[] args) {

        // Membership number
        GymMember member = new GymMember(1000);

        System.out.println(
                "Membership Number: "
                + member.getMembershipNumber());

        System.out.println(
                "Members Enrolled: "
                + GymMember.getMembersEnrolled());

        // Referral code validation
        System.out.println(
                "G45B: "
                + GymMember.isValidReferralCode("G45B"));

        System.out.println(
                "G4B: "
                + GymMember.isValidReferralCode("G4B"));

        System.out.println(
                "X45B: "
                + GymMember.isValidReferralCode("X45B"));

        // Overloaded payFee()
        member.payFee(500);
        member.payFee(500, "UPI");

        System.out.println(
                "Fees Paid: "
                + member.getFeesPaid());

        // Weekly check-in
        GroupClassMember group =
                new GroupClassMember(
                        1500,
                        "Zumba");

        GymMember individual =
                new GymMember(1000);

        GymMember[] members = {
            group,
            null,
            individual
        };

        System.out.println(
                GymMember.processWeeklyCheckIn(
                        members));
    }
}