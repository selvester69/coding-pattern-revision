package leetcode.array;
import java.util.*;

public class P16LongestConsequtiveSequence {
    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        P16LongestConsequtiveSequence.longestConsecutive(nums);
    }

    //BruteForce
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int x = nums[i];
            while (set.contains(x--)) {
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }

    //my accepted Solution
    public int longestConsecutiveApproach2(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[0];
        int maxCount = max-min+1;
        for (int i = 1; i < nums.length; i++) {
             if (nums[i] - nums[i-1] == 1) {
               max = nums[i];
            } else if(nums[i] - nums[i-1] > 1) {
                 min = nums[i];
            }
            maxCount = Math.max(max-min+1, maxCount);
        }
        return maxCount;
    }
}
