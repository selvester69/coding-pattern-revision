package com.practice.algorithms.scottbarett.trees;

import com.practice.algorithms.scottbarett.stackQueue.Stack;
import com.practice.datastructure.trees.BinarySearchTree;
import com.practice.datastructure.trees.Node;

public class KthSmallestNodeBST extends BinarySearchTree {
    public static void main(String[] args) {

        KthSmallestNodeBST bst = new KthSmallestNodeBST();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        System.out.println(bst.kthSmallest(1)); // Expected output: 2
        System.out.println(bst.kthSmallest(3)); // Expected output: 4
        System.out.println(bst.kthSmallest(6)); // Expected output: 7

    }

    public Integer kthSmallest(int k) {
        Stack<Node> stack = new Stack<>();
        Node node = this.root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            k--;
            if (k == 0) {
                return node.value;
            }
            node = node.right;
        }
        return null;
    }
}
