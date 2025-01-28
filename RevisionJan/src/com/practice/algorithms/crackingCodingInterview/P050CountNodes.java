package com.practice.algorithms.crackingCodingInterview;

public class P050CountNodes {

    public static int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // TODO: write test case
    // for now validated against leetcode

}
