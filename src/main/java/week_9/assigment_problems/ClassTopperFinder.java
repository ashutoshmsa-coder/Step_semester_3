package week_9.assigment_problems;

public class ClassTopperFinder {

    public static int[] findTopper(int[][] marks) {

        int bestRow = 0;
        int bestTotal = 0;

        for (int row = 0; row < marks.length; row++) {

            int total = 0;

            for (int col = 0; col < marks[row].length; col++) {
                total += marks[row][col];
            }

            // Use > so the first student wins if totals are equal
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = row;
            }
        }

        return new int[]{bestRow, bestTotal};
    }

    public static void main(String[] args) {

        int[][] marks = {
                {78, 85, 90},
                {88, 92, 79},
                {65, 70, 95}
        };

        int[] result = findTopper(marks);

        System.out.println("Topper Row Index: " + result[0]);
        System.out.println("Highest Total: " + result[1]);
    }
}