package com.practice.algorithms.crackingCodingInterview.P014RecursionIntermediate;

public class SumOfArrayRecursive {

    public static int sumOfArr(int[] nums, int n,int index) {
       if(index>=n) return 0;

       //recursive case 
       int ans = nums[index];

       return ans+sumOfArr(nums, n, index+1);
    }

    public static void main(String[] args) {
        // Test cases
        int[] emptyArray = {};
        int[] singleElementArray = {5};
        int[] positiveArray = {1, 2, 3, 4, 5};
        int[] negativeArray = {-1, -2, -3, -4, -5};
        int[] mixedArray = {-1, 2, -3, 4, -5};
        int[] largeArray = new int[1000];
        for (int i = 0; i < 1000; i++) {
            largeArray[i] = i + 1;
        }


        System.out.println("Test 1: Empty Array - Expected: 0, Actual: " + sumOfArr(emptyArray, emptyArray.length, 0));
        System.out.println("Test 2: Single Element Array - Expected: 5, Actual: " + sumOfArr(singleElementArray, singleElementArray.length, 0));
        System.out.println("Test 3: Positive Array - Expected: 15, Actual: " + sumOfArr(positiveArray, positiveArray.length, 0));
        System.out.println("Test 4: Negative Array - Expected: -15, Actual: " + sumOfArr(negativeArray, negativeArray.length, 0));
        System.out.println("Test 5: Mixed Array - Expected: -3, Actual: " + sumOfArr(mixedArray, mixedArray.length, 0));
        System.out.println("Test 6: Large Array - Expected: 500500, Actual: " + sumOfArr(largeArray, largeArray.length, 0)); //Sum of numbers from 1 to 1000
        System.out.println("Test 7: Start Index in Middle - Expected: 9, Actual: " + sumOfArr(positiveArray, positiveArray.length, 2)); // Sum from index 2 (3+4+5)
        System.out.println("Test 8: Start Index at End - Expected: 5, Actual: " + sumOfArr(positiveArray, positiveArray.length, 4)); // Sum from index 4 (5)
        System.out.println("Test 9: Index out of bound - Expected: 0, Actual: " + sumOfArr(positiveArray, positiveArray.length, 5)); // Index is out of bound
        System.out.println("Test 10: Null array - Expected: 0, Actual: " + sumOfArr(null, 0, 0));

    }

}
