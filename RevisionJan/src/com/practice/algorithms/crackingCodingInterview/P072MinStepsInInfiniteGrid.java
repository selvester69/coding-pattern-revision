package com.practice.algorithms.crackingCodingInterview;

import java.util.ArrayList;
import java.util.List;

public class P072MinStepsInInfiniteGrid {
    // assuming both vectors have same length
    // min step to point is Max(x2-x1, y2-y1); take abs of difference
    // in question it is given that we can move in all 8 directions
    // that is why we can calculate like this.
    public static int minSteps(List<Integer> A, List<Integer> B) {
        int count = 0;
        for (int i = 1; i < A.size(); i++) {
            count += Math.max(
                    Math.abs(A.get(i) - A.get(i - 1)), Math.abs(B.get(i) - B.get(i - 1)));
        }
        return count;
    }

    // we are allowed to move in 4 direction only
    // we combine both x and y movement
    public static int minSteps4direction(List<Integer> A, List<Integer> B) {
        int count = 0;
        for (int i = 1; i < A.size(); i++) {
            count += Math.abs(A.get(i) - A.get(i - 1))
                    + Math.abs(B.get(i) - B.get(i - 1)); // add both x and y movement and we geet the count
        }
        return count;
    }
    public static void main(String[] args) {

    
        // Test case 1
        ArrayList<Integer> X1 = new ArrayList<>();
        ArrayList<Integer> Y1 = new ArrayList<>();
        X1.add(0); Y1.add(0);
        X1.add(1); Y1.add(1);
        X1.add(1); Y1.add(2);
        System.out.println("Test Case 1: " + minSteps(X1, Y1)); // Expected: 2

        // Test case 2
        ArrayList<Integer> X2 = new ArrayList<>();
        ArrayList<Integer> Y2 = new ArrayList<>();
        X2.add(0); Y2.add(0);
        X2.add(1); Y2.add(1);
        X2.add(1); Y2.add(2);
        X2.add(3); Y2.add(4);
        System.out.println("Test Case 2: " + minSteps(X2, Y2)); // Expected: 4

        // Test case 3
        ArrayList<Integer> X3 = new ArrayList<>();
        ArrayList<Integer> Y3 = new ArrayList<>();
        X3.add(-7); Y3.add(-13);
        X3.add(1); Y3.add(5);
        System.out.println("Test Case 3: " + minSteps(X3, Y3)); // Expected: 18

        // Test case 4: Single point
        ArrayList<Integer> X4 = new ArrayList<>();
        ArrayList<Integer> Y4 = new ArrayList<>();
        X4.add(0); Y4.add(0);
        System.out.println("Test Case 4: " + minSteps(X4, Y4)); // Expected: 0

        // Test case 5: Empty input
        ArrayList<Integer> X5 = new ArrayList<>();
        ArrayList<Integer> Y5 = new ArrayList<>();
        System.out.println("Test Case 5: " + minSteps(X5, Y5)); // Expected: 0
    


        ////////////////////no diagonal test case
        

        // Test case 1
        X1 = new ArrayList<>();
        Y1 = new ArrayList<>();
        X1.add(0); Y1.add(0);
        X1.add(1); Y1.add(1);
        X1.add(1); Y1.add(2);
        System.out.println("Test Case 1: " + minSteps4direction(X1, Y1)); // Expected: 3

        // Test case 2
        X2 = new ArrayList<>();
        Y2 = new ArrayList<>();
        X2.add(0); Y2.add(0);
        X2.add(1); Y2.add(1);
        X2.add(1); Y2.add(2);
        X2.add(3); Y2.add(4);
        System.out.println("Test Case 2: " + minSteps4direction(X2, Y2)); // Expected: 7

        // Test case 3
        X3 = new ArrayList<>();
        Y3 = new ArrayList<>();
        X3.add(-7); Y3.add(-13);
        X3.add(1); Y3.add(5);
        System.out.println("Test Case 3: " + minSteps4direction(X3, Y3)); // Expected: 26

        // Test case 4: Single point
        X4 = new ArrayList<>();
        Y4 = new ArrayList<>();
        X4.add(0); Y4.add(0);
        System.out.println("Test Case 4: " + minSteps4direction(X4, Y4)); // Expected: 0

        // Test case 5: Empty input
        X5 = new ArrayList<>();
        Y5 = new ArrayList<>();
        System.out.println("Test Case 5: " + minSteps4direction(X5, Y5)); // Expected: 0
    }

}
