package com.practice.algorithms.crackingCodingInterview.P015RecursionAdvanced;

public class ConvertStringToIntRecursive {

    public static int aToI(String ip, int n) {
        // basecase
        if (n == 0)
            return 0;

        // small ans
        int small = aToI(ip, n - 1);
        int last = ip.toUpperCase().charAt(n) - 'A';
        int ans = small * 10 + last;
        return ans;
    }

}
