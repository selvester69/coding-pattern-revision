package leetcode.array;

import java.util.*;

public class P18ContiguousArray {
    public static void main(String[] args) {
        int[] nums = new int[] { 0, 0, 1, 0, 0, 0, 1, 1 };
        System.out.println(P18ContiguousArray.findMaxLength(nums));
        // System.out.println(P18ContiguousArray.findMaxLength(new int[]{0,1,1}));
    }

    public static int findMaxLength(int[] nums) {
        int length = 0;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(0) == map.get(1)) {
                length = map.get(0) + map.get(1);
                maxLength = Math.max(length, maxLength);
            }
            if (map.get(nums[i]) > 1) {
                map.put(nums[i], map.get(nums[i]) - 1);
            }
        }
        return maxLength;
    }

    // time limit exceeded Solution
    public static int findMaxLengthBruteForce(int[] nums) {
        int maxLength = 0;
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            int zero = 0;
            int one = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zero++;
                } else {
                    one++;
                }
                if (zero == one) {
                    length = j - i + 1;
                    maxLength = Math.max(maxLength, length);
                    // break;
                }
            }
        }
        return maxLength;
    }
}
