package leetcode.array;
import java.util.Arrays;
public class P10ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int nums[] = new int[] { 1, 2, 3, 4 };
        int res[] = P10ProductOfArrayExceptSelf.productExceptSelf(nums);
        Arrays.stream(res).forEach(item-> System.out.print(item+" "));
    }

    public static int[] productExceptSelf(int[] nums) {
        int res[] = new int[nums.length];
        
        return res;
    }




    
    public static int[] productExceptSelfBrutreForce(int[] nums) {
        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                } else {
                    prod = prod * nums[j];
                }
            }
            res[i] = prod;
        }
        return res;
    }

}
