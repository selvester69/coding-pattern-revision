package com.practice.algorithms.scottbarett.stackQueue;

public class SortStack extends Stack<Integer> {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Before sorting:");
        stack.printStack();

        sortStack(stack);

        System.out.println("\nAfter sorting:");
        stack.printStack();

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * Before sorting:
         * 4
         * 1
         * 5
         * 2
         * 3
         * 
         * After sorting:
         * 1
         * 2
         * 3
         * 4
         * 5
         * 
         */

    }

    private static void sortStack(Stack<Integer> stack) {
        
    }

}
