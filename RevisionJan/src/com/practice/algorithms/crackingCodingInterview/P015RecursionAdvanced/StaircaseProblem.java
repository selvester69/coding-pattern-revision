package com.practice.algorithms.crackingCodingInterview.P015RecursionAdvanced;

public class StaircaseProblem {

    public static int staircase(int N) {
        //base case
        if(N<0) return 0;

        if (N == 0 || N == 1) {
            return 1;
        }
        //recursive case + calculations
        return staircase(N - 1) + staircase(N - 2) + staircase(N - 3);
    }

    public static void main(String[] args) {
        System.out.println(staircase(4));
    }

}
