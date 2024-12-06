package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class P04ContainsDuplicate {

    public static void main(String[] args) {
        boolean res = P04ContainsDuplicate.containsDuplicate(new int[] {1,1,1,3,3,4,3,4,2});
        System.out.println(res); 
    }


    public static boolean containsDuplicate(int[] nums) {
         Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static boolean containsDuplicateBruteForce(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
