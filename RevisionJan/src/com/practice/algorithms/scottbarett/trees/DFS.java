package com.practice.algorithms.scottbarett.trees;

import java.util.ArrayList;
import java.util.List;

import com.practice.datastructure.trees.BinarySearchTree;
import com.practice.datastructure.trees.Node;

public class DFS extends BinarySearchTree {
    public static void main(String[] args) {

        DFS myBST = new DFS();

        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);

        System.out.println("DFS PreOrder: [47, 21, 18, 27, 76, 52, 82]");
        System.out.println(myBST.DFSPreOrder());
        System.out.println("DFS InOrder:  [18, 21, 27, 47, 52, 76, 82]");
        System.out.println(myBST.DFSInOrder());
        System.out.println("DFS PostOrder:  [18, 27, 21, 52, 82, 76, 47]");
        System.out.println(myBST.DFSPostOrder());

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * DFS PreOrder:
         * [47, 21, 18, 27, 76, 52, 82]
         * 
         */

    }

    private List<Integer> DFSPreOrder() {
        List<Integer> res = new ArrayList<>();
        preOrder(this.root, res);
        return res;
    }

    private void preOrder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.value);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    private List<Integer> DFSInOrder() {
        List<Integer> res = new ArrayList<>();
        inOrder(this.root, res);
        return res;
    }

    private void inOrder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.value);
        inOrder(root.right, res);
    }

    private List<Integer> DFSPostOrder() {
        List<Integer> res = new ArrayList<>();
        postOrder(this.root, res);
        return res;
    }

    private void postOrder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.value);
    }

}
