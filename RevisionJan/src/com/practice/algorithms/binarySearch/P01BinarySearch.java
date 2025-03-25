package com.practice.algorithms.binarySearch;

public class P01BinarySearch {

    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = { -1, 0, 3, 5, 9, 12 };
        int target1 = 9;
        int result1 = search(nums1, target1);
        System.out.println("Test Case 1:");
        System.out.println("Input nums: " + java.util.Arrays.toString(nums1));
        System.out.println("Input target: " + target1);
        System.out.println("Output: " + result1);
        System.out.println("Expected Output: 4");
        System.out.println();

        // Test Case 2
        int[] nums2 = { -1, 0, 3, 5, 9, 12 };
        int target2 = 2;
        int result2 = search(nums2, target2);
        System.out.println("Test Case 2:");
        System.out.println("Input nums: " + java.util.Arrays.toString(nums2));
        System.out.println("Input target: " + target2);
        System.out.println("Output: " + result2);
        System.out.println("Expected Output: -1");
        System.out.println();

        // Additional Test Cases (Optional, but good for thorough testing)

        // Test Case 3: Target at the beginning
        int[] nums3 = { 2, 5, 7, 8, 11, 12 };
        int target3 = 2;
        int result3 = search(nums3, target3);
        System.out.println("Test Case 3:");
        System.out.println("Input nums: " + java.util.Arrays.toString(nums3));
        System.out.println("Input target: " + target3);
        System.out.println("Output: " + result3);
        System.out.println("Expected Output: 0");
        System.out.println();

        // Test Case 4: Target at the end
        int[] nums4 = { 2, 5, 7, 8, 11, 12 };
        int target4 = 12;
        int result4 = search(nums4, target4);
        System.out.println("Test Case 4:");
        System.out.println("Input nums: " + java.util.Arrays.toString(nums4));
        System.out.println("Input target: " + target4);
        System.out.println("Output: " + result4);
        System.out.println("Expected Output: 5");
        System.out.println();

        // Test Case 5: Single element array, target found
        int[] nums5 = { 5 };
        int target5 = 5;
        int result5 = search(nums5, target5);
        System.out.println("Test Case 5:");
        System.out.println("Input nums: " + java.util.Arrays.toString(nums5));
        System.out.println("Input target: " + target5);
        System.out.println("Output: " + result5);
        System.out.println("Expected Output: 0");
        System.out.println();

        // Test Case 6: Single element array, target not found
        int[] nums6 = { 5 };
        int target6 = -5;
        int result6 = search(nums6, target6);
        System.out.println("Test Case 6:");
        System.out.println("Input nums: " + java.util.Arrays.toString(nums6));
        System.out.println("Input target: " + target6);
        System.out.println("Output: " + result6);
        System.out.println("Expected Output: -1");
        System.out.println();

        // Test Case 7: Empty array
        int[] nums7 = {};
        int target7 = 5;
        int result7 = search(nums7, target7);
        System.out.println("Test Case 7:");
        System.out.println("Input nums: " + java.util.Arrays.toString(nums7));
        System.out.println("Input target: " + target7);
        System.out.println("Output: " + result7);
        System.out.println("Expected Output: -1");
        System.out.println();
    }

}
