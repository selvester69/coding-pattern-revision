package com.practice.algorithms.crackingCodingInterview;

import java.util.LinkedList;
import java.util.Queue;

public class P059InvertABinaryTree {

    // dfs solution
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        return root;
    }

    public TreeNode invertTree_bfs(TreeNode root) {
        if (root == null)
            return root;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);

            TreeNode temp2 = temp.left;
            temp.left = temp.right;
            temp.right = temp2;
        }
        return root;
    }
}
