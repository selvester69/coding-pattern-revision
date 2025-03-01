package com.practice.algorithms.crackingCodingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P079HotelReviews {
    class Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public List<Integer> hotelReviews(String A, List<String> S) {
        Set<String> hs = new HashSet<>();
        for (String str : A.split("_")) {
            hs.add(str);
        }
        Pair[] res = new Pair[S.size()];
        for (int i = 0; i < S.size(); i++) {
            String[] str = S.get(i).split("_");
            int count = 0;
            for (String s : str) {
                if (hs.contains(s))
                    count++;
            }
            res[i] = new Pair(i, count);
        }
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(res, (a, b) -> {
            return b.second - a.second;
        });
        for (int i = 0; i < res.length; i++) {
            ans.add(res[i].first);
        }
        System.out.println(ans);
        return ans;
    }

    //this solution contains trie.
    public List<Integer> hotelReviews_usingTrie(String A, List<String> S) {
        P078Trie trie = new P078Trie();
        for (String str : A.split("_")) {
            trie.insert(str);
        }
        Pair[] res = new Pair[S.size()];
        for (int i = 0; i < S.size(); i++) {
            String[] str = S.get(i).split("_");
            int count = 0;
            for (String s : str) {
                if (trie.search(s))
                    count++;
            }
            res[i] = new Pair(i, count);
        }
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(res, (a, b) -> {
            return b.second - a.second;
        });
        for (int i = 0; i < res.length; i++) {
            ans.add(res[i].first);
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        P079HotelReviews hr = new P079HotelReviews();

        // Test Case 1: Simple case
        String A1 = "cool_wifi";
        List<String> B1 = Arrays.asList("cool_wifi_is_good", "bad_wifi_is_not_cool", "very_cool_wifi");
        List<Integer> expected1 = Arrays.asList(0, 1, 2); // Replace with expected result
        test(hr, A1, B1, expected1, "Test Case 1");

        // Test Case 2: Empty keywords
        String A2 = "";
        List<String> B2 = Arrays.asList("some_review", "another_review");
        List<Integer> expected2 = Arrays.asList(0, 1); // Replace with expected result
        test(hr, A2, B2, expected2, "Test Case 2");

        // Test Case 3: Empty reviews
        String A3 = "good";
        List<String> B3 = Arrays.asList("good", "good_good");
        List<Integer> expected3 = Arrays.asList(1, 0); // Replace with expected result
        test(hr, A3, B3, expected3, "Test Case 3");

    }

    private static void test(P079HotelReviews hr, String A, List<String> B, List<Integer> expected, String testName) {
        List<Integer> actual = hr.hotelReviews_usingTrie(A, B);
        // List<Integer> actual = hr.hotelReviews(A, B);
        System.out.println(testName + ": " + (actual.equals(expected) ? "Passed" : "Failed"));
        if (!actual.equals(expected)) {
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
        }
    }

}
