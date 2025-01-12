package com.practice.algorithms.scottbarett.hashTable.set;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> myList = List.of(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5);
        List<Integer> newList = removeDuplicates(myList);
                System.out.println(newList);
        
                /*
                 * EXPECTED OUTPUT:
                 * ----------------
                 * [1, 2, 3, 4, 5, 6, 7, 8, 9]
                 * 
                 * (Order may be different as sets are unordered)
                 */
        
            }
        
            private static List<Integer> removeDuplicates(List<Integer> myList) {
                Set<Integer> set = new LinkedHashSet<>();
                for(Integer i:myList){
                    set.add(i);
                }
                return new ArrayList<>(set);
            }

}
