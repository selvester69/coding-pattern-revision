package com.practice.algorithms.crackingCodingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P045InorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }


    public static void main(String[] args) {
        P045InorderTraversal traversal = new P045InorderTraversal();

        // Test case 1: Empty tree
        test(traversal, null, new Integer[]{});

        // Test case 2: Single node
        TreeNode root2 = new TreeNode(1);
        test(traversal, root2, new Integer[]{1});

        // Test case 3: Left-leaning tree
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.left.left = new TreeNode(3);
        test(traversal, root3, new Integer[]{3, 2, 1});

        // Test case 4: Right-leaning tree
        TreeNode root4 = new TreeNode(1);
        root4.right = new TreeNode(2);
        root4.right.right = new TreeNode(3);
        test(traversal, root4, new Integer[]{1, 2, 3});

        // Test case 5: Balanced tree
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.right = new TreeNode(3);
        test(traversal, root5, new Integer[]{2, 1, 3});

        // Test case 6: More complex balanced tree
        TreeNode root6 = new TreeNode(1);
        root6.left = new TreeNode(2);
        root6.right = new TreeNode(3);
        root6.left.left = new TreeNode(4);
        root6.left.right = new TreeNode(5);
        test(traversal, root6, new Integer[]{4, 2, 5, 1, 3});

        // Test case 7: Another complex tree
        TreeNode root7 = new TreeNode(1);
        root7.left = new TreeNode(4);
        root7.right = new TreeNode(2);
        root7.right.left = new TreeNode(3);
        test(traversal, root7, new Integer[]{4, 1, 3, 2});
    }

    private static void test(P045InorderTraversal traversal, TreeNode root, Integer[] expected) {
        List<Integer> actual = traversal.inorderTraversal(root);
        List<Integer> expectedList = Arrays.asList(expected);

        System.out.println("Input Tree:");
        printTree(root);
        System.out.println("Expected: " + expectedList);
        System.out.println("Actual: " + actual);

        if (actual.equals(expectedList)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        System.out.println("---------------");
    }

        private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }

        System.out.print(root.val + " ");
        System.out.print("Left: ");
        printTree(root.left);
        System.out.print("Right: ");
        printTree(root.right);
    }
}
