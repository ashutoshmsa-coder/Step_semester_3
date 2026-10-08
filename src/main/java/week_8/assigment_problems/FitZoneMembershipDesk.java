package week_8.assigment_problems;

interface MembershipPlan {
    double calculateFee();
    String getPlanName();
}

class MonthlyPlan implements MembershipPlan {

    @Override
    public double calculateFee() {
        return 1000;
    }

    @Override
    public String getPlanName() {
        return "Monthly";
    }
}

class QuarterlyPlan implements MembershipPlan {

    @Override
    public double calculateFee() {
        return 1000 * 3 * 0.90;
    }

    @Override
    public String getPlanName() {
        return "Quarterly";
    }
}

class AnnualPlan implements MembershipPlan {

    @Override
    public double calculateFee() {
        return 1000 * 12 * 0.75;
    }

    @Override
    public String getPlanName() {
        return "Annual";
    }
}

class Member {
    private String name;

    Member(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

class Membership {

    private Member member;
    private MembershipPlan plan;
    private String status;

    Membership(Member member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;
        this.status = "Active";
    }

    void displayMembership() {
        System.out.printf(
            "%s membership created for %s.%n",
            plan.getPlanName(),
            member.getName()
        );

        System.out.printf(
            "Fee: ₹%.2f%n",
            plan.calculateFee()
        );

        System.out.println(
            "Status: " + status
        );
    }

    void checkIn() {
        if (status.equals("Active")) {
            System.out.println(
                member.getName() +
                " checked in successfully."
            );
        } else {
            System.out.println(
                "Check-in denied: " +
                member.getName() +
                "'s membership is " +
                status + "."
            );
        }
    }

    void freeze() {

        if (status.equals("Expired")) {
            System.out.println(
                "Cannot freeze an Expired membership."
            );
            return;
        }

        if (status.equals("Frozen")) {
            System.out.println(
                member.getName() +
                "'s membership is already Frozen."
            );
            return;
        }

        status = "Frozen";

        System.out.println(
            member.getName() +
            "'s membership frozen."
        );

        System.out.println(
            "Status: " + status
        );
    }

    void unfreeze() {

        if (status.equals("Expired")) {
            System.out.println(
                "Cannot unfreeze an Expired membership."
            );
            return;
        }

        if (!status.equals("Frozen")) {
            System.out.println(
                "Membership is not Frozen."
            );
            return;
        }

        status = "Active";

        System.out.println(
            member.getName() +
            "'s membership unfrozen."
        );

        System.out.println(
            "Status: " + status
        );
    }

    void expire() {

        if (status.equals("Expired")) {
            System.out.println(
                "Membership is already Expired."
            );
            return;
        }

        status = "Expired";

        System.out.println(
            member.getName() +
            "'s membership expired."
        );

        System.out.println(
            "Status: " + status
        );
    }
}

public class FitZoneMembershipDesk {

    public static void main(String[] args) {

        Member asha =
            new Member("Asha");

        Member ravi =
            new Member("Ravi");

        MembershipPlan quarterly =
            new QuarterlyPlan();

        MembershipPlan monthly =
            new MonthlyPlan();

        Membership ashaMembership =
            new Membership(
                asha,
                quarterly
            );

        Membership raviMembership =
            new Membership(
                ravi,
                monthly
            );

        // Asha buys Quarterly membership
        ashaMembership.displayMembership();

        System.out.println();

        // Ravi buys Monthly membership
        raviMembership.displayMembership();

        System.out.println();

        // Asha checks in
        ashaMembership.checkIn();

        System.out.println();

        // Asha freezes membership
        ashaMembership.freeze();

        System.out.println();

        // Asha attempts check-in while frozen
        ashaMembership.checkIn();

        System.out.println();

        // Ravi membership expires
        raviMembership.expire();

        System.out.println();

        // Ravi attempts to freeze expired membership
        raviMembership.freeze();
    }
}