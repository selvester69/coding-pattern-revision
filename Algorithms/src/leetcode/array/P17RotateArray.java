package leetcode.array;

import java.util.*;

public class P17RotateArray {
    public static void main(String[] args) {
        int[]nums = new int[]{1,2,3,4,5,6,7};
        int k=0;
        P17RotateArray.rotate(nums, k);
        Arrays.stream(nums).forEach(item -> System.out.print(item + " "));
    }

    public static void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverseBetween(nums, 0, nums.length - 1);
        reverseBetween(nums, 0, k - 1);
        reverseBetween(nums, k, nums.length - 1);

    }

    public static void reverseBetween(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
    }

    //Brute force o(n^2) - time limit exeeeded
    public static void rotateBruteForce(int[] nums, int k) {
        int n = nums.length;
        while(k>0){
            int temp = nums[n-1];
            for(int i=n-1;i>0;i--){
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
            k--;
        }
    }

}
