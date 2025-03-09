package com.practice.algorithms.leetcode;

public class Leetcode3206 {

    public int fixedAlternatinggroup(int[] colors) {
        int count = 0;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] != colors[(i - 1 + colors.length) % colors.length]
                    && colors[i] != colors[(i + 1) % colors.length]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Leetcode3206 obj = new Leetcode3206();

        System.out.println(obj.fixedAlternatinggroup(new int[] { 0, 1, 0, 0, 1 }));
    }

}
