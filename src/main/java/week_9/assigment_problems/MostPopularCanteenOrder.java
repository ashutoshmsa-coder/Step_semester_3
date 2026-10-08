package week_9.assigment_problems;

import java.util.HashMap;
import java.util.Map;

public class MostPopularCanteenOrder {

    public static String[] mostPopular(String[] orders) {

        Map<String, Integer> countMap = new HashMap<>();

        // First pass: count each item
        for (String order : orders) {
            countMap.put(order, countMap.getOrDefault(order, 0) + 1);
        }

        String popularItem = orders[0];
        int highestCount = countMap.get(popularItem);

        // Second pass: preserve first occurrence in case of a tie
        for (String order : orders) {

            int currentCount = countMap.get(order);

            if (currentCount > highestCount) {
                highestCount = currentCount;
                popularItem = order;
            }
        }

        return new String[]{popularItem, String.valueOf(highestCount)};
    }

    public static void main(String[] args) {

        String[] orders1 = {
                "dosa", "idli", "vada",
                "dosa", "idli", "dosa", "tea"
        };

        String[] result1 = mostPopular(orders1);

        System.out.println("Most Popular Item: " + result1[0]);
        System.out.println("Count: " + result1[1]);

        String[] orders2 = {
                "tea", "coffee", "coffee", "tea"
        };

        String[] result2 = mostPopular(orders2);

        System.out.println("Most Popular Item: " + result2[0]);
        System.out.println("Count: " + result2[1]);
    }
}