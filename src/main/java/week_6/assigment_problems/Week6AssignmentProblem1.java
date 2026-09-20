package week_6.assigment_problems;

public class Week6AssignmentProblem1 {

    public static void main(String[] args) {

        PremiumMember p =
                new PremiumMember(
                        "MEM01",
                        2000,
                        "Coach Riya");

        p.attendSession();
        p.attendSession();

        System.out.println(
                "Sessions Attended: "
                + p.getSessionsAttended());

        String[] memberIds = {
            "MEM1",
            "GM1",
            "MEM2",
            " ",
            "MEM3"
        };

        System.out.println(
                GymMember.signUpBatch(
                        memberIds, 1000));
    }
}