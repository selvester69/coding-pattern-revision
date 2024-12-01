package leetcode;
import java.util.*;
public class MajorityElement {

    public static void main(String[] args) {
        int res = MajorityElement.majorityElement(new int[] { 2,2,1,1,1,2,2 });
        System.out.println(res);
    }

    public static int majorityElement(int[] nums) {
        if(nums.length==1) return nums[0];
        int majority = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority) {
                count++;
            } else {
                count--;
            }
            if (count < 1) {
                majority = nums[i];
                count = 1;
            }
        }
        return majority;
    }



    public static int majorityElementBruteForce(int[] nums) {
        int majority = 0;
        for(int i=0;i<nums.length;i++){
            int count =0;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]) count++;
            }
            if(count>nums.length/2){
                majority = nums[i];
                break;
            }
        }
        return majority;
    }

    //o(N) time and O(N) space
    public static int majorityElementSolution2(int[] nums) {
        int n = nums.length;
        int majority = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>n/2){
                majority = nums[i];
                break;
            }
        }
        return majority;
    }
}
