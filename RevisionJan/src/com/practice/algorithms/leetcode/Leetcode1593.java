package com.practice.algorithms.leetcode;

public class Leetcode1593 {

    public int findKthPositive(int[] arr, int k) {
        int n = arr[arr.length - 1] + k;
        int last = 0;
        int kth = 0;
        int i = 1, index = 0;
        while (i <= n) {
            if (index<arr.length && i == arr[index]) {
                index++;
            } else {
                last = i;
                kth++;
            }
            i++;
            if (kth == k) {
                return last;
            }
        }
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        Leetcode1593 obj = new Leetcode1593();
        System.out.println(obj.findKthPositive(new int[] { 1, 2, 3, 4 }, 2));
    }

}
