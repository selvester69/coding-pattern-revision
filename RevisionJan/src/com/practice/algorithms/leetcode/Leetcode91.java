package com.practice.algorithms.leetcode;

public class Leetcode91 {
public static int numDecodings(String s) {
        return rec(s,0);
    }

    private static int rec(String s, int i){
        if(i==s.length()){
            return 1;
        }
        if(s.charAt(i)=='0') return 0;

        int res = rec(s,i+1);
        if(i<s.length()-1){
            if(s.charAt(i)=='1'|| (s.charAt(i)=='2' && s.charAt(i+1)<'7')){
                res += rec(s, i+2);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(numDecodings("06"));
    }
}
