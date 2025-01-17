package com.practice.algorithms.scottbarett.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.practice.datastructure.trees.BinarySearchTree;
import com.practice.datastructure.trees.Node;

public class InvertBinaryTree extends BinarySearchTree {

    public ArrayList<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        if (currentNode != null) {
            queue.add(currentNode);
        }

        while (queue.size() > 0) {
            currentNode = queue.remove();
            if (currentNode != null) {
                results.add(currentNode.value);
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }
        return results;
    }

    private static void performTest(String description, int[] insertValues, Integer[] expectedValues,
            boolean doubleInversion) {
        InvertBinaryTree bst = new InvertBinaryTree();
        for (int value : insertValues) {
            bst.insert(value);
        }
        if (doubleInversion) {
            bst.invert(); // First inversion
        }
        bst.invert(); // Perform inversion (or second inversion for the specific case)

        ArrayList<Integer> resultList = bst.BFS();

        // Use Arrays.asList for compatibility with older Java versions
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(expectedValues));

        System.out.println(description + ": " + (expectedList.equals(resultList) ? "Pass" : "Fail"));
        System.out.println("Expected: " + expectedList);
        System.out.println("Actual:   " + resultList);
    }

    private static void testInvertBinarySearchTree() {
        System.out.println("--- Testing Inversion of Binary Search Tree ---");

        performTest("Invert an empty tree", new int[] {}, new Integer[] {}, false);
        performTest("Invert a tree with a single node", new int[] { 1 }, new Integer[] { 1 }, false);
        performTest("Invert a tree with only a left child", new int[] { 2, 1 }, new Integer[] { 2, null, 1 }, false);
        performTest("Invert a tree with only a right child", new int[] { 1, 2 }, new Integer[] { 1, 2 }, false);
        performTest("Invert a full binary tree", new int[] { 2, 1, 3 }, new Integer[] { 2, 3, 1 }, false);
        performTest("Invert a more complex binary tree", new int[] { 4, 2, 6, 1, 3, 5, 7 },
                new Integer[] { 4, 6, 2, 7, 5, 3, 1 }, false);
        performTest("Double inversion returns original", new int[] { 3, 1, 4 }, new Integer[] { 3, 1, 4 }, true);
    }

    public static void main(String[] args) {
        testInvertBinarySearchTree();
    }

    private void invert() {
        this.root = invert(this.root);
    }

    private Node invert(Node curr) {
        if (curr == null)
            return null;
        Node temp = curr.left;
        curr.left = invert(curr.right);
        curr.right = invert(temp);
        return curr;
    }

}
