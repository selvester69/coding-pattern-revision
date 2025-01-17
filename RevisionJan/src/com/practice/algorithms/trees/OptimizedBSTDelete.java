package com.practice.algorithms.trees;

import com.practice.datastructure.trees.Node;

public class OptimizedBSTDelete {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(18);
        int x = 15;

        root = delNode(root, x);
        inorder(root);
    }

    static Node delNode(Node root, int k) {
        if (root == null)
            return root;
        if (k < root.value) {
            root.left = delNode(root.left, k);
            return root;
        } else if (k > root.value) {
            root.right = delNode(root.right, k);
            return root;
        }

        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        Node successorParent = root;
        Node successor = root.right;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }

        root.value = successor.value;// copy min value from right child
        // remove successor Node
        if (successorParent.left == successor) {
            successorParent.left = successor.right;
        } else {
            successorParent.right = successor.right;
        }

        return root;
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }
}
