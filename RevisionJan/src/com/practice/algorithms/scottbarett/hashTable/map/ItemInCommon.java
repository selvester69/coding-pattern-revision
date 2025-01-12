package com.practice.algorithms.scottbarett.hashTable.map;

import java.util.*;

public class ItemInCommon {
    public static void main(String[] args) {
        int[] array1 = { 1, 3, 5 };
        int[] array2 = { 2, 4, 5 };

        System.out.println(itemInCommon(array1, array2));

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * true
         * 
         */
    }

    public static boolean itemInCommon(int[] array1, int[] array2) {
        Set<Integer> set = new HashSet<>();
        for (int a1 : array1) {
            set.add(a1);
        }
        for (int a1 : array2) {
            if (set.contains(a1)) {
                return true;
            }
        }
        return false;
    }

}
