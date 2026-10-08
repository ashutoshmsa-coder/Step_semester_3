package week_9.assigment_problems;

public class MaximizeContainerArea {

    public static int maxContainerArea(int[] heights) {

        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {

            int width = right - left;

            int height = Math.min(heights[left], heights[right]);

            int area = height * width;

            if (area > maxArea) {
                maxArea = area;
            }

            // Move the pointer with the smaller height
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result = maxContainerArea(heights);

        System.out.println("Maximum Container Area: " + result);
    }
}