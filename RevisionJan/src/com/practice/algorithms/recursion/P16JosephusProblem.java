package com.practice.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class P16JosephusProblem {

    /**
     * Solution 1
     * 
     * @param n
     * @param k
     * @return
     */
    public int findTheWinnerIterative(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (index + k - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    /**
     * Solution 2
     * 
     * @param n
     * @param k
     * @return
     */
    public int findTheWinnerListRecursive(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int index = 0;
        return recur(k, index, list);
    }

    public int recur(int k, int index, List<Integer> list) {
        if (list.size() <= 1) {
            return list.get(0);
        }
        index = (index + k - 1) % list.size();
        list.remove(index);
        return recur(k, index, list);
    }

    /**
     * solution 3
     * 
     * @param args
     */
    public void recursive(int k, int index, List<Integer> list) {
        // base case
        if (list.size() == 0) {
            System.out.println(list.get(0));
        }
        // hypothesis
        index = (index + k) % list.size();
        
        // induction


    }

    public static void main(String[] args) {
        P16JosephusProblem obj = new P16JosephusProblem();
        System.out.println(obj.findTheWinnerIterative(5, 2));
        System.out.println(obj.findTheWinnerListRecursive(5, 2));
    }
}
