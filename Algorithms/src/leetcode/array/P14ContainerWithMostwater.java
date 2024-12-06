package leetcode.array;

public class P14ContainerWithMostwater {

    public static void main(String[] args) {
        int[] height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int res = P14ContainerWithMostwater.maxArea(height);
        System.out.println(res);// 49 correct
    }

    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxLeft = height[i], maxRight = height[j];
        int maxArea = 0;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(maxArea, area);
            if (height[i] < height[j]) {
                while (height[i] <= maxLeft && i < j) {
                    i++;
                }
                maxLeft = height[i];
            } else {
                while (height[j] <= maxRight && i < j) {
                    j--;
                }
                maxRight = height[j];
            }
        }
        return maxArea;
    }

    // improved approach
    public static int maxAreaApproach1(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = 0;
        while (i <= j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(maxArea, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    public static int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int area = 0;
            for (int j = i + 1; j < height.length; j++) {
                area = Math.max(area, (Math.min(height[i], height[j]) * (j - i)));
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
