package com.practice.datastructure.trees;

public class RrecursiveBSTMain {

    public static void main(String[] args) {

        BinarySearchTreeRecursive myBST = new BinarySearchTreeRecursive();

        myBST.insert(2);
        myBST.insert(1);
        myBST.insert(3);

        /*
         * 2
         * / \
         * 1 3
         */

        System.out.println("Root: " + myBST.getRoot().value);
        System.out.println("Root->Left: " + myBST.getRoot().left.value);
        System.out.println("Root->Right: " + myBST.getRoot().right.value);

        myBST.rDelete(2);

        /*
         * 3
         * / \
         * 1 null
         */

        System.out.println("\nRoot: " + myBST.getRoot().value);
        System.out.println("Root->Left: " + myBST.getRoot().left.value);
        System.out.println("Root->Right: " + myBST.getRoot().right);

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * Root: 2
         * Root->Left: 1
         * Root->Right: 3
         * 
         * Root: 3
         * Root->Left: 1
         * Root->Right: null
         * 
         */

    }

}
