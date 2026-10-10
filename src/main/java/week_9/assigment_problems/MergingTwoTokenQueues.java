package week_9.assigment_problems;

import java.util.Arrays;

public class MergingTwoTokenQueues {

    public static int[] mergeTokens(int[] counterA, int[] counterB) {

        int m = counterA.length;
        int n = counterB.length;

        int[] result = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;

        // Compare elements from both arrays
        while (i < m && j < n) {

            if (counterA[i] <= counterB[j]) {
                result[k] = counterA[i];
                i++;
            } else {
                result[k] = counterB[j];
                j++;
            }

            k++;
        }

        // Copy remaining elements from counterA
        while (i < m) {
            result[k] = counterA[i];
            i++;
            k++;
        }

        // Copy remaining elements from counterB
        while (j < n) {
            result[k] = counterB[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] counterA = {3, 8, 15, 20};
        int[] counterB = {5, 8, 12};

        int[] result = mergeTokens(counterA, counterB);

        System.out.println("Merged Tokens: "
                + Arrays.toString(result));

        // Test with an empty list
        int[] counterC = {};
        int[] counterD = {4, 9};

        int[] result2 = mergeTokens(counterC, counterD);

        System.out.println("Second Result: "
                + Arrays.toString(result2));
    }
}