package com.practice.algorithms.crackingCodingInterview;

public class P051MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    // TODO: write test case
    // for now validated against leetcode
}
