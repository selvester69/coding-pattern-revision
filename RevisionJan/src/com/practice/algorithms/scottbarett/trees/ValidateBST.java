package com.practice.algorithms.scottbarett.trees;

import java.util.ArrayList;
import java.util.List;

import com.practice.datastructure.trees.BinarySearchTree;
import com.practice.datastructure.trees.Node;

public class ValidateBST extends BinarySearchTree {

    public static void main(String[] args) {
        testSingleNodeTree();
        testValidBST();
        testValidBSTWithDeepLeftSubtree();
        testValidBSTWithDeepRightSubtree();
        testBalancedBST();
    }

    private static void testSingleNodeTree() {
        System.out.println("\n----- Test: Single Node Tree -----\n");
        ValidateBST bst = new ValidateBST();
        bst.insert(10);
        printIsValidBST(bst);
    }

    private static void testValidBST() {
        System.out.println("\n----- Test: Valid BST -----\n");
        ValidateBST bst = new ValidateBST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        printIsValidBST(bst);
    }

    private static void testValidBSTWithDeepLeftSubtree() {
        System.out.println("\n----- Test: BST With Deep Left Subtree -----\n");
        ValidateBST bst = new ValidateBST();
        bst.insert(10);
        bst.insert(8);
        bst.insert(6);
        bst.insert(4);
        bst.insert(2);
        printIsValidBST(bst);
    }

    private static void testValidBSTWithDeepRightSubtree() {
        System.out.println("\n----- Test: BST With Deep Right Subtree -----\n");
        ValidateBST bst = new ValidateBST();
        bst.insert(10);
        bst.insert(12);
        bst.insert(14);
        bst.insert(16);
        bst.insert(18);
        printIsValidBST(bst);
    }

    private static void testBalancedBST() {
        System.out.println("\n----- Test: Balanced BST -----\n");
        ValidateBST bst = new ValidateBST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(2);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);
        printIsValidBST(bst);
    }

    private static void printIsValidBST(ValidateBST bst) {
        System.out.println("Is valid BST: " + bst.isValidBST());
    }

    private boolean isValidBST() {
        List<Integer> res = inOrder();
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) < res.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> inOrder() {
        List<Integer> res = new ArrayList<>();
        inOrder(this.root, res);
        return res;
    }

    private void inOrder(Node root, List<Integer> res) {
        if (root == null)
            return;
        inOrder(root.left, res);
        res.add(root.value);
        inOrder(root.right, res);
    }

}
