package com.practice.algorithms.recursion;

public class P08TowerOfHanoi {

    public void toh(int N, String s, String d, String h) {
        if (N == 0)
            return;
        toh(N - 1, s, h, d);
        System.out.println("Moving " + N + " disc from " + s + " to " + d);
        toh(N - 1, h, d, s);
    }

    public static void main(String[] args) {
        P08TowerOfHanoi obj = new P08TowerOfHanoi();
        obj.toh(4, "source", "dest", "helper");
    }
}
