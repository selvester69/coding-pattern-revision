package leetcode.array;

import java.util.Arrays;

public class P06MoveZeros {

    public static void main(String[] args) {
        int nums[] = new int[] { 1, 2, 4, 0, 1, 0, 3, 12 };
        // int nums[] = new int[] { 2,1 };
        P06MoveZeros.moveZeroes(nums);
        Arrays.stream(nums).forEach(item -> System.out.print(item + " "));
    }

    public static void moveZeroes(int[] nums) {
        int count = 0;
        for (int num: nums) {
            if (num != 0) nums[count ++] = num;
        }
        for (int i = count; i < nums.length; i ++) nums[i] = 0;
    }
    
    public static void moveZeroesApproach3(int[] nums) {
        int i = 0, j = 0;
        while (j != nums.length) {
            if (nums[j] != 0) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
            }
            j++;
        }
    }

    public static void moveZeroes2msSolution(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return;
        int i = 0, j = i + 1;
        while (i < n && nums[i] != 0) {
            i++;
        }
        while (i < n) {
            if (j < i) {
                j = i;
            }
            while (j < n && nums[j] == 0) {
                j++;
            }
            if (j < n && nums[j] != 0) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
            i++;
        }

    }

    public static void moveZeroes2msSolutionApproach2(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return;
        int i = 0, j = -1;
        while (i < n) {
            if (nums[i] != 0) {
                i++;
                continue;
            }
            if (j < i) {
                j = i;
            }
            while (j < n && nums[j] == 0) {
                j++;
            }
            if (j < n && nums[j] != 0) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
            i++;
        }
    }

    public static void moveZeroesApproach2(int[] nums) {
        if (nums.length < 2)
            return;
        int i = 0, j = 0;
        while (j < nums.length) {
            while (i < nums.length && nums[i] != 0) {
                i++;
            }
            j = i + 1;
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            if (j < nums.length && i < nums.length) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
            }
        }
    }

    public static void moveZeroesBruteForce(int[] nums) {
        if (nums.length < 2)
            return;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                continue;
            }
            inner: for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] != 0) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                    break inner;
                }
            }
        }
    }

}
