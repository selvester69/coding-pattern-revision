package otherProblems;

public class P02RangeOfSumBetweenLR {

    public static void main(String[] args) {
        int n = 6;
        int[] a = { 3, 6, 2, 8, 9, 2 };
        int[]pf = P02RangeOfSumBetweenLR.prefixSum(a);
        int[][] q = { { 2, 3 }, { 4, 6 }, { 1, 5 }, { 3, 6 } };
        for (int i = 0; i < q.length; i++) {
            int l = q[i][0];
            int r = q[i][1];

            // Calculating sum from r to l.
            System.out.print(pf[r] - pf[l - 1] + "\n");
        }
    }
    public static int[] prefixSum(int[]nums) {
        int[]res = new int[nums.length+1];
        res[0] =0;
        for(int i=0;i<nums.length;i++){
            res[i+1] = res[i]+nums[i];
        }
        return res;
    }

}
