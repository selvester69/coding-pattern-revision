package com.practice.algorithms.crackingCodingInterview.P015RecursionAdvanced;

public class ReplaceCharRecursively {

    public static void replaceChar(char[] ch, char x, char a, int index) {
        if (ch == null || ch.length == 0 || ch.length == index) {
            return;
        }
        if (ch[index] == x) {
            ch[index] = a;
        }
        replaceChar(ch, x, a, index + 1);
    }

}
