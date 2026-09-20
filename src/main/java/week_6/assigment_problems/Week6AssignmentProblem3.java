package week_6.assigment_problems;

import java.util.Arrays;

public class Week6AssignmentProblem3 {

    public static void main(String[] args) {

        PremiumMember member =
                new PremiumMember(
                        "MEM5",
                        2000,
                        "Coach Riya");

        member.chargeLateFee(200);

        System.out.println(
                "Total Late Fees: "
                + member.getTotalLateFees());

        int[] history =
                member.getLateFeeHistory();

        System.out.println(
                "Late Fee History: "
                + Arrays.toString(history));

        history[0] = 999;

        System.out.println(
                "After Changing Copy: "
                + Arrays.toString(
                        member.getLateFeeHistory()));

        System.out.println(
                "Final Total Late Fees: "
                + member.getTotalLateFees());
    }
}