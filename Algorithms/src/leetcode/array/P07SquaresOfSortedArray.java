package leetcode.array;

import java.util.Arrays;
// Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?

public class P07SquaresOfSortedArray {

    public static void main(String[] args) {
        int[]res = P07SquaresOfSortedArray.sortedSquares(new int[]{-4,-1,0,3,10});
        Arrays.stream(res).forEach(item-> System.out.print(item+" "));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int start = 0,end = nums.length-1;
        int count = nums.length-1;
        while(start<=end){
            if(nums[start]*nums[start] >= nums[end]*nums[end] ){
                res[count--] = nums[start]*nums[start];
                start++;
            }else {
                res[count--] = nums[end]*nums[end];
               end--;
            }
        }
        return res;
    }

}
