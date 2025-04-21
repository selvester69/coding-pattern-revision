package com.practice.algorithms.recursion;

//try to understand the problem
/**
 * 0
 * 0|1
 * 01|10
 * 0110|1001
 * 01101001|10010110
 * as per observational skills first half is same as previous of n-1 row and
 * another half is complement of itself
 * therefore
 * solve(N,K) -> solve(N-1,K) = if(k<mid);
 * if(k>mid)=> solve(N,K)-> !solve(N-1, K-mid); //not of ans
 */
public class P07KsymbolIngrammar {

    // recursion working solution
    public int solve(int N, int K) {
        if (N == 1 && K == 1) {
            return 0;
        }
        int mid = ((int) Math.pow(2, N - 1)) / 2;
        if (K <= mid) {
            return solve(N - 1, K);
        } else {
            return solve(N - 1, K - mid) == 0 ? 1 : 0;
        }
    }

    // this is time limit exceeded solution.
    public int kthGrammar(int n, int k) {
        if (k - 1 > Math.pow(2, n - 1) || k == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        rec(sb, n);
        System.out.println(sb.toString());
        return Integer.parseInt(sb.charAt(k - 1) + "");
    }

    public void rec(StringBuilder symbol, int n) {
        if (n == 0)
            return;
        int i = symbol.length() - 1;
        while (i >= 0) {
            if (symbol.charAt(i) == '1') {
                symbol.replace(i, i + 1, "10");
            } else {
                symbol.replace(i, i + 1, "01");
            }
            i--;
        }
        rec(symbol, n - 1);
    }

    public static void main(String[] args) {
        P07KsymbolIngrammar obj = new P07KsymbolIngrammar();
        // System.out.println(obj.kthGrammar(1, 1));
        // System.out.println(obj.kthGrammar(2, 3));
        System.out.println(obj.solve(1, 1));
        System.out.println(obj.solve(5, 3));
    }
}
