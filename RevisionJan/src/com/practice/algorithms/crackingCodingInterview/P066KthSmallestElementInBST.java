package com.practice.algorithms.crackingCodingInterview;

public class P066KthSmallestElementInBST {


    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        int[]count = new int[]{0};
        int[]ans = new int[]{0};
        inorder(root, count, ans, k);
        return ans[0];
    }

    public void inorder(TreeNode root, int[] count, int[] ans, int k) {
        if (root == null)
            return;
        inorder(root.left, count, ans, k);
        count[0]++;
        if (count[0] == k) {
            ans[0] = root.val;
        }
        inorder(root.right, count, ans, k);
    }
}
