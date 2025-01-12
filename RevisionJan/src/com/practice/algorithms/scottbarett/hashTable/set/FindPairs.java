package com.practice.algorithms.scottbarett.hashTable.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPairs {

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target){
        Set<Integer> set = new HashSet<>();
        for(int i:arr1){
            set.add(i);
        }
        List<int[]> res = new ArrayList<>();
        for(int i:arr2){
            if(set.contains(target-i)){
                res.add(new int[]{target-i,i});
            }
        }
        return res;
    }

     public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8, 10};
        int target = 7;

        List<int[]> pairs = findPairs(arr1, arr2, target);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

        /*
            EXPECTED OUTPUT:
            ----------------
            [5, 2]
            [3, 4]
            [1, 6]
            
        */
        
    }

}
