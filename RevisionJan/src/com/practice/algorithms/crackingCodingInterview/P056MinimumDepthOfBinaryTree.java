package com.practice.algorithms.crackingCodingInterview;

import java.util.LinkedList;
import java.util.Queue;

public class P056MinimumDepthOfBinaryTree {

    public int minDepth_dfs(TreeNode root) {
        if (root == null)
            return 0;
        // if both child is null count 1 node
        if (root.left == null && root.right == null)
            return 1;

        // if any one is null traverse other
        if (root.left == null)
            return 1 + minDepth_dfs(root.right);

        if (root.right == null)
            return 1 + minDepth_dfs(root.left);

        // other wise find min of left and right
        return Math.min(1 + minDepth_dfs(root.left), 1 + minDepth_dfs(root.right));
    }

    class Item {
        TreeNode node;
        int depth;

        public Item(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int minDepth_bfs(TreeNode root) {
        if (root == null)
            return 0;
        Queue<Item> q = new LinkedList<>();
        q.add(new Item(root, 1));

        while (!q.isEmpty()) {
            Item item = q.poll();
            TreeNode temp = item.node;
            int depth = item.depth;
            if (temp.left == null && temp.right == null)
                return depth;

            if (temp.left != null)
                q.add(new Item(temp.left, depth + 1));
            if (temp.right != null)
                q.add(new Item(temp.right, depth + 1));
        }
        return 0;
    }

}
