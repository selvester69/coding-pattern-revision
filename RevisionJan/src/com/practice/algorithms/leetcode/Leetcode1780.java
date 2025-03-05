package com.practice.algorithms.leetcode;

public class Leetcode1780 {

    public boolean checkPowerOfThree(int n) {
        return backTrack(0, n);
    }

    public boolean backTrack(int power, int n) {
        // base case
        if (n == 0) {
            return true;
        }
        if (n < Math.pow(3, power)) {
            return false;
        }
        // include
        boolean addPower = backTrack(power + 1, n - (int) Math.pow(3, power));
        // exclude
        boolean skipPower = backTrack(power + 1, n);
        return addPower || skipPower;
    }

    // Approach 2
    public boolean checkPowerOfThree_expected(int n) {
        // calculate the power of 3 >=n;
        int power = 0;
        while (Math.pow(3, power) <= n) {
            power++;
        }
        // subtract power of 3 one by one from n and check if value becomes less than n
        while (n > 0) {
            if (n >= Math.pow(3, power)) {
                n = n - (int) Math.pow(3, power);
            }
            // if(3^power) is stil greater than n means we have to use same power twice
            // which should not happen therefore return false;
            if (n >= Math.pow(3, power)) {
                return false;
            }
            power--;
        }
        return true;
    }

    // Approach 3
    public boolean checkPowerOfThree_ternaryRep(int n) {
        // convert n to it's ternary representation and if any remainder becomes 2 that
        // means not possible
        while (n > 0) {
            if (n % 3 == 2)
                return false;
            n = n / 3;
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode1780 obj = new Leetcode1780();
        System.out.println(obj.checkPowerOfThree(12));
    }
}