package com.practice.algorithms.crackingCodingInterview;

public class P048SameTree {

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

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;

        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        P048SameTree st = new P048SameTree();

        // Test case 1: Both trees are null
        test(st, null, null, true);

        // Test case 2: One tree is null, the other is not
        TreeNode p2 = new TreeNode(1);
        test(st, p2, null, false);
        test(st, null, p2, false);

        // Test case 3: Single node trees, same value
        TreeNode p3 = new TreeNode(1);
        TreeNode q3 = new TreeNode(1);
        test(st, p3, q3, true);

        // Test case 4: Single node trees, different values
        TreeNode p4 = new TreeNode(1);
        TreeNode q4 = new TreeNode(2);
        test(st, p4, q4, false);

        // Test case 5: Identical trees
        TreeNode p5 = new TreeNode(1);
        p5.left = new TreeNode(2);
        p5.right = new TreeNode(3);
        TreeNode q5 = new TreeNode(1);
        q5.left = new TreeNode(2);
        q5.right = new TreeNode(3);
        test(st, p5, q5, true);

        // Test case 6: Trees with different structures
        TreeNode p6 = new TreeNode(1);
        p6.left = new TreeNode(2);
        TreeNode q6 = new TreeNode(1);
        q6.right = new TreeNode(2);
        test(st, p6, q6, false);

        // Test case 7: Trees with different values
        TreeNode p7 = new TreeNode(1);
        p7.left = new TreeNode(2);
        TreeNode q7 = new TreeNode(1);
        q7.left = new TreeNode(3);
        test(st, p7, q7, false);

        // Test case 8: Larger trees, same structure, different values
        TreeNode p8 = new TreeNode(1);
        p8.left = new TreeNode(2);
        p8.right = new TreeNode(3);
        p8.left.left = new TreeNode(4);

        TreeNode q8 = new TreeNode(1);
        q8.left = new TreeNode(2);
        q8.right = new TreeNode(5); // Different value
        q8.left.left = new TreeNode(4);
        test(st, p8, q8, false);

        // Test case 9: Larger trees, same values, different structure
        TreeNode p9 = new TreeNode(1);
        p9.left = new TreeNode(2);
        p9.right = new TreeNode(3);
        p9.left.left = new TreeNode(4);

        TreeNode q9 = new TreeNode(1);
        q9.left = new TreeNode(2);
        q9.right = new TreeNode(3);
        q9.right.left = new TreeNode(4); // Different structure
        test(st, p9, q9, false);

        // Test case 10: Larger trees, same structure and values
        TreeNode p10 = new TreeNode(1);
        p10.left = new TreeNode(2);
        p10.right = new TreeNode(3);
        p10.left.left = new TreeNode(4);
        p10.left.right = new TreeNode(5);

        TreeNode q10 = new TreeNode(1);
        q10.left = new TreeNode(2);
        q10.right = new TreeNode(3);
        q10.left.left = new TreeNode(4);
        q10.left.right = new TreeNode(5);
        test(st, p10, q10, true);

        //Test case 11: One tree has null children, other doesn't
        TreeNode p11 = new TreeNode(1);
        p11.left = new TreeNode(2);

        TreeNode q11 = new TreeNode(1);
        q11.left = new TreeNode(2);
        q11.right = new TreeNode(3);
        test(st, p11, q11, false);

    }

    private static void test(P048SameTree st, TreeNode p, TreeNode q, boolean expected) {
        boolean actual = isSameTree(p, q);

        System.out.println("Tree 1:");
        printTree(p);
        System.out.println("Tree 2:");
        printTree(q);

        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);

        if (actual == expected) {
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
