package com.practice.algorithms.recursion;

public class P01Print1ToN {

    public void print(int n) {
        if (n == 0)
            return;

        print(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        P01Print1ToN obj = new P01Print1ToN();
        obj.print(10);
    }

}
