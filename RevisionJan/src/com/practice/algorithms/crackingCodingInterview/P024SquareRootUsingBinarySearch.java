package com.practice.algorithms.crackingCodingInterview;

public class P024SquareRootUsingBinarySearch {

    public static int sqRoot(int x) {
        if (x == 0)
            return 0;
        int start = 1;
        int end = x;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid <= x / mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        System.out.println(sqRoot(2147395599));
    }

}
