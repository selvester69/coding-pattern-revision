package com.practice.algorithms.crackingCodingInterview;

public class P010ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        int begin = 0;
        int end = s.length() - 1;
        while(begin<end){
            if(s.charAt(begin)!= s.charAt(end)){
                return isPalindrome(s,begin+1, end)|| isPalindrome(s,begin, end-1);
            }
            begin++;end--;
        }
        return true;

    }
    private boolean isPalindrome(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        P010ValidPalindrome2 tester = new P010ValidPalindrome2();

        System.out.println("Test 1: \"aba\" - Expected: true, Actual: " + tester.validPalindrome("aba"));
        System.out.println("Test 2: \"abca\" - Expected: true, Actual: " + tester.validPalindrome("abca"));
        System.out.println("Test 3: \"abc\" - Expected: false, Actual: " + tester.validPalindrome("abc"));
        System.out.println("Test 4: \"deeee\" - Expected: true, Actual: " + tester.validPalindrome("deeee"));
        System.out.println("Test 5: \"aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucmlmgmqfvnbgtapekouga\" - Expected: true, Actual: " + tester.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucmlmgmqfvnbgtapekouga"));
        System.out.println("Test 6: \"race a car\" - Expected: false, Actual: " + tester.validPalindrome("race a car"));
        System.out.println("Test 7: \"lcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucul\" - Expected: true, Actual: " + tester.validPalindrome("lcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucul"));
        System.out.println("Test 8: \"eeccccbebaeeabebccceea\" - Expected: true, Actual: " + tester.validPalindrome("eeccccbebaeeabebccceea"));

    }
}
