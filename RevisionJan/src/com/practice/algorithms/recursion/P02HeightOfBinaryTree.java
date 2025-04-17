package com.practice.algorithms.recursion;

public class P02HeightOfBinaryTree {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Inorder dfs

    public void printTree(Node root) {
        if (root == null)
            return;
        printTree(root.left);
        System.out.println(root.data);
        printTree(root.right);

    }

    public int height(Node root) {
        if (root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }
}
