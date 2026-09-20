package week_6.class_problems;

import java.util.Arrays;

public class Week6Problem3 {

    public static void main(String[] args) {

        StudentMember s =
                new StudentMember("STU5", 3, "CSE");

        // Charge a fine of 100
        s.chargeFine(100);

        // Student gets 50% discount
        System.out.println(
                "Total Fine: " + s.getTotalFine()
        );

        // Get fine history
        int[] history = s.getFineHistory();

        System.out.println(
                "Fine History: " + Arrays.toString(history)
        );

        // Try to modify the returned array
        history[0] = 999;

        // Original history must not change
        System.out.println(
                "After Changing Copy: "
                + Arrays.toString(s.getFineHistory())
        );

        // Total should still be 50
        System.out.println(
                "Final Total Fine: " + s.getTotalFine()
        );
    }
}