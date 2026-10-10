package week_9.class_problems;

import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSum {

    public static boolean hasPairWithTargetSum(
            int[] numbers, int target) {

        Set<Integer> seen = new HashSet<>();

        for (int number : numbers) {

            int complement = target - number;

            if (seen.contains(complement)) {
                return true;
            }

            seen.add(number);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;

        int[] numbers2 = {3, 4, 6};
        int target2 = 20;

        System.out.println("Example 1: "
                + hasPairWithTargetSum(numbers1, target1));

        System.out.println("Example 2: "
                + hasPairWithTargetSum(numbers2, target2));
    }
}