package otherProblems;

import java.util.Arrays;

public class P03 {
    public static void main(String[] args) {
        int n = 5, m = 3;
        int[] a = new int[n];
        Arrays.fill(a, 0);
        int r[][] = { { 2, 4 }, { 1, 3 }, { 1, 2 } };
        int res = P03.solve(a, r, m);
        System.out.println(res);
    }

    public static int solve(int nums[], int[][] range, int m) {
            while(m>0){
                
            }
        return Arrays.stream(nums).max().getAsInt();
    }
    public static int solveBruteForce(int nums[], int[][] range, int m) {
            for(int j=0;j<range.length;j++){
                int l = range[j][0],r=range[j][1];
                while(l<=r){
                    nums[l]+=100;
                    l++;
                }
            }
        return Arrays.stream(nums).max().getAsInt();
    }
}
