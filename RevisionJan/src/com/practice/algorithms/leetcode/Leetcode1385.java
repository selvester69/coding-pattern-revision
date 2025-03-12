package com.practice.algorithms.leetcode;

public class Leetcode1385 {
    public int numberOfSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String sub = s.substring(i,j+1);
                if(containsThree(sub)){
                    System.out.println(sub);
                    count++;
                }
            }
        }
        return count;
    }
    public boolean containsThree(String sub){
        if(sub.contains("a")&& sub.contains("b")&& sub.contains("c")){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Leetcode1385 obj = new Leetcode1385();
        System.out.println(obj.numberOfSubstrings("abcabc"));
    }

}
