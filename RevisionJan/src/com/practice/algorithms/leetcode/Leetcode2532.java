package com.practice.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode2532 {

    public int[] closestPrimes(int left, int right) {
        if (right - left < 2) {
            return new int[] { -1, -1 };
        }
        List<Integer> prime = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (i % 2 == 0 && i > 2) {
                continue;
            }
            if (isPrime(i)) {
                // check for twin prime
                if (!prime.isEmpty() && i <= prime.get(prime.size() - 1) + 2) {
                    return new int[] { prime.get(prime.size() - 1), i };
                }
                prime.add(i);
            }
        }
        if (prime.size() < 2) {
            return new int[] { -1, -1 };
        }
        int minDiff = 1000000;
        int[] ans = new int[] { -1, -1 };
        for (int i = 1; i < prime.size(); i++) {
            int diff = prime.get(i) - prime.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                ans[0] = prime.get(i - 1);
                ans[1] = prime.get(i);
            }
        }
        return ans;
    }

    public boolean isPrime(int n) {
        if (n <= 0)
            return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode2532 obj = new Leetcode2532();
        int[] ans = obj.closestPrimes(10, 19);
        System.out.println(Arrays.toString(ans));
    }
}
