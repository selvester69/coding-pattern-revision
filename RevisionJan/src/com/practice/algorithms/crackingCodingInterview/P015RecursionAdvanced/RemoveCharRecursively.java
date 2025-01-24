package com.practice.algorithms.crackingCodingInterview.P015RecursionAdvanced;

public class RemoveCharRecursively {

    public static void removeChar(char[] ch, int index, char a) {
        if (ch == null || ch.length == 0 || index == ch.length) {
            return;
        }
        if (ch[index] != a) {
            removeChar(ch, index + 1, a);
        } else {
            int temp = index;
            while (temp < ch.length - 1) {
                ch[temp] = ch[temp + 1];
            }
            removeChar(ch, index, a);
        }
    }

}
