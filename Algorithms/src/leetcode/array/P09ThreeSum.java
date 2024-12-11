package leetcode.array;

import java.util.*;

public class P09ThreeSum {
    public static void main(String[] args) {
        int[] nums = { 1, 2, -2, -1 };
        List<List<Integer>> res = P09ThreeSum.threeSum(nums);
        System.out.println(res);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    Collections.sort(temp);
                    res.add(temp);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static List<List<Integer>> threeSumHashTwonSumApproach(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int currSum = -(nums[i] + nums[j]);
                if (set.contains(currSum)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], currSum);
                    Collections.sort(temp);
                    res.add(temp);
                } else {
                    set.add(nums[j]);
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);
                        if (!res.contains(temp)) {
                            res.add(temp);
                        }
                    }
                }
            }
        }
        return res;
    }
}
