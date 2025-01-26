package com.practice.algorithms.crackingCodingInterview;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P030ReverseWordsInString {

    public static String reverseWords(String s) {
        if (s.length() == 0) {
            return s;
        }
        char[] ch = s.toCharArray();
        int begin = 0, end = 0;
        // 1. reverse each word in a string
        while (ch[end] == ' ') {
            end++;
            begin++;
        }
        while (end < ch.length) {
            if (s.charAt(end) == ' ') {
                reverse(ch, begin, end - 1);// because space is encountered.
                end++;
                begin = end;
            } else {
                end++;
            }
        }
        // still last word is left
        reverse(ch, begin, end - 1);// assuming end word has no space
        // 2. reverse whole String
        reverse(ch, 0, ch.length - 1);

        StringBuilder sb = new StringBuilder();

        // 3. remove extra space
        int index = 0;
        while (ch[index] == ' ') {
            index++;
        }
        while (index < ch.length) {
            if (ch[index] == ' ') {
                sb.append(" ");
                index++;
                while (index < ch.length && ch[index] == ' ')
                    index++;
            } else {
                sb.append(ch[index]);
                index++;
            }
        }
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.append("-").toString();
    }

    public static void reverse(char[] ch, int begin, int end) {
        while (begin <= end) {
            char temp = ch[begin];
            ch[begin] = ch[end];
            ch[end] = temp;
            begin++;
            end--;
        }
    }

    public static String reverWord_bruteForce(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String reverse_java8version(String s) {
        if (s == null)
            return s;
        s = s.trim();
        if (s.equals("")) {
            return s;
        }
        List<String> words = Arrays.asList(s.split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords(" hello world "));
        System.out.println(reverWord_bruteForce("     hello    world     "));
        System.out.println(reverse_java8version("     hello    world     "));
    }

}
