package week_9.assigment_problems;

public class TicketPriceSlotFinder {

    public static int findSlot(int[] prices, int newPrice) {

        int low = 0;
        int high = prices.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (prices[mid] < newPrice) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        int[] prices = {120, 150, 200, 260};

        int result1 = findSlot(prices, 150);
        int result2 = findSlot(prices, 210);
        int result3 = findSlot(prices, 300);

        System.out.println("Slot for 150: " + result1);
        System.out.println("Slot for 210: " + result2);
        System.out.println("Slot for 300: " + result3);
    }
}
