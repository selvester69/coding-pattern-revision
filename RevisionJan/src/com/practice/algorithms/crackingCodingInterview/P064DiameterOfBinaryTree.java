package com.practice.algorithms.crackingCodingInterview;

public class P064DiameterOfBinaryTree {

    // naiveApproach

    // calculating height for every node is recursive
    // to optimize we calcualte height and diameter in one pass
    public int diameterOfTree(TreeNode root) {
        if (root == null)
            return 0;
        int ld = diameterOfTree(root.left);
        int rd = diameterOfTree(root.right);
        int option = height(root.left) + height(root.right);
        return Math.max(option, Math.max(ld, rd));
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // approach 2 : efficient one.
    class Pair {
        int h;
        int d;

        Pair(int h, int d) {
            this.h = h;
            this.d = d;
        }
    }

    public int diameterTree(TreeNode root) {
        if (root == null)
            return 0;
        Pair p = helper(root);
        return p.d;
    }

    public Pair helper(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        int height = 1 + Math.max(left.h, right.h);
        int diameter = Math.max(left.h + right.h, Math.max(left.d, right.d));
        return new Pair(height, diameter);
    }

    // similar to approach 2:
    // using a single variable as reference
    public int diameter(TreeNode root) {
        if (root == null)
            return 0;
        int[] res = new int[] { 0 };
        diameter_helper(root, res);
        return res[0];
    }

    public int diameter_helper(TreeNode root, int[] res) {
        if (root == null)
            return 0;
        int leftH = diameter_helper(root.left, res);
        int rightH = diameter_helper(root.right, res);

        res[0] = Math.max(res[0], leftH + rightH);
        return 1+ Math.max(leftH, rightH);
    }

}
