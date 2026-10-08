package week_9.assigment_problems;

public class HotWeatherAlertWindows {

    public static int countAlerts(
            int[] readings, int k, int threshold) {

        int windowSum = 0;
        int alertCount = 0;

        // Calculate the first window
        for (int i = 0; i < k; i++) {
            windowSum += readings[i];
        }

        // Check the first window
        if (windowSum >= k * threshold) {
            alertCount++;
        }

        // Slide the window
        for (int i = k; i < readings.length; i++) {

            windowSum += readings[i];
            windowSum -= readings[i - k];

            if (windowSum >= k * threshold) {
                alertCount++;
            }
        }

        return alertCount;
    }

    public static void main(String[] args) {

        int[] readings = {
                2, 2, 2, 2, 5, 5, 5, 8
        };

        int k = 3;
        int threshold = 4;

        int result = countAlerts(
                readings, k, threshold);

        System.out.println("Number of Alerts: " + result);
    }
}