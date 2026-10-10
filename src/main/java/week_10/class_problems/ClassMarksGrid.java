import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassMarksGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> names = new ArrayList<>();
        List<int[]> marksList = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+", 2);
            String name = parts[0];

            String marksText = parts[1]
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "");

            String[] values = marksText.trim().split("\\s+");

            int[] marks = new int[3];

            for (int i = 0; i < 3; i++) {
                marks[i] = Integer.parseInt(values[i]);
            }

            names.add(name);
            marksList.add(marks);
        }

        int studentCount = names.size();

        if (studentCount == 0) {
            sc.close();
            return;
        }

        int[] totals = new int[studentCount];
        int[] subjectTotals = new int[3];

        int topperIndex = 0;

        for (int i = 0; i < studentCount; i++) {
            int[] marks = marksList.get(i);

            for (int j = 0; j < 3; j++) {
                totals[i] += marks[j];
                subjectTotals[j] += marks[j];
            }

            if (totals[i] > totals[topperIndex]) {
                topperIndex = i;
            }
        }

        System.out.print("Totals ");

        for (int i = 0; i < studentCount; i++) {
            if (i > 0) {
                System.out.print(", ");
            }

            System.out.print(names.get(i) + " " + totals[i]);
        }

        System.out.println();

        System.out.printf(
                "averages %.2f, %.2f, %.2f%n",
                subjectTotals[0] / (double) studentCount,
                subjectTotals[1] / (double) studentCount,
                subjectTotals[2] / (double) studentCount
        );

        System.out.println(
                "topper " + names.get(topperIndex) +
                " (" + totals[topperIndex] + ")"
        );

        sc.close();
    }
}