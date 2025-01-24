package com.practice.algorithms.crackingCodingInterview.P015RecursionAdvanced;

public class TowerOfHanoi {

    public static void toh(int n, char s, char h, char d) {
        if (n == 0)
            return;
        toh(n - 1, s, d, h);
        System.out.println("moving " + n + "th disc from " + s + " to " + d + " using " + h);
        toh(n - 1, h, d, s);
    }

    public static void main(String[] args) {
        toh(4, 'S', 'H', 'D');
    }

}
