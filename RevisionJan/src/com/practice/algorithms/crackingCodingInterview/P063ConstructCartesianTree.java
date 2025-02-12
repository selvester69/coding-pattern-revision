package com.practice.algorithms.crackingCodingInterview;

// cartesian tree is the tree where root is greater than all elements in the sub tree

// given inorder traversal of cartesian tree 
// build the tree 
// inorder traversal is [left Root right]
public class P063ConstructCartesianTree {

    public static TreeNode buildCartesianTree_minTree(int[] arr) {
        if (arr.length == 0)
            return null;
        return helper(arr, 0, arr.length - 1);
    }

    public static TreeNode helper(int[] inorder, int s, int e) {
        if (s > e)
            return null;
        int maxVal = Integer.MAX_VALUE;
        int maxIndex = -1;
        for (int i = s; i <= e; i++) {
            if (inorder[i] < maxVal) {
                maxIndex = i;
                maxVal = inorder[i];
            }
        }
        TreeNode node = new TreeNode(maxVal);
        node.left = helper(inorder, s, maxIndex - 1);
        node.right = helper(inorder, maxIndex + 1, e);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = buildCartesianTree_minTree(new int[] { 3, 2, 6, 1, 9 });
        inorderTraversal(root);
        // System.out.println(root);
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            inorderTraversal(root.left);
        System.out.println(root.val + " ");
        if (root.right != null)
            inorderTraversal(root.right);
    }

    public static TreeNode buildCartesianTree_maxTree(int[] arr) {
        if (arr.length == 0)
            return null;
        return helper_maxTree(arr, 0, arr.length - 1);
    }

    public static TreeNode helper_maxTree(int[] inorder, int s, int e) {
        if (s > e)
            return null;
        int maxVal = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = s; i <= e; i++) {
            if (inorder[i] > maxVal) {
                maxIndex = i;
                maxVal = inorder[i];
            }
        }
        TreeNode node = new TreeNode(maxVal);
        node.left = helper_maxTree(inorder, s, maxIndex - 1);
        node.right = helper_maxTree(inorder, maxIndex + 1, e);
        return node;
    }
}
