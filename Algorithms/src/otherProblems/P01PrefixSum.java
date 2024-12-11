package otherProblems;

import java.util.Arrays;

public class P01PrefixSum {

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};  
        int[]res =P01PrefixSum.prefixSumBruteForce(nums);
        Arrays.stream(res).forEach(item-> System.out.print(item+" "));
    }

    public static int[] prefixSumBruteForce(int[]nums) {
        int res[] = new int[nums.length];
        res[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            res[i] = res[i-1]+nums[i];
        }
        return res;
    }

}
