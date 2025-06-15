package com.practice.algorithms.leetcode;

public class Leetcode5 {
    
    public static String longestPalindrome(String s) {
        int n = s.length();
        int res=0; int idx = 0;
        for(int i=0;i<n;i++){
            //odd
            int l=i,r=i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(r-l+1>res){
                    res = r-l+1;
                    idx = l;
                }
                l--;r++;
            }
            //even
             l=i;
             r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(r-l+1>res){
                    res = r-l+1;
                    idx = l;
                }
                l--;r++;

            }
        }
        return s.substring(idx, idx+res);
    }

    public static void main(String[] args) {
        // System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("a"));
    }

}
