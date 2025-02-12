package com.practice.datastructure.trees;

import java.util.ArrayList;
import java.util.List;

import com.practice.algorithms.scottbarett.stackQueue.Stack;

public class DFSIterative extends BinarySearchTree {

    public static void main(String[] args) {

        DFSIterative myBST = new DFSIterative();

        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);

        // System.out.println("DFS PreOrder: [47, 21, 18, 27, 76, 52, 82]");
        // System.out.println(myBST.DFSInOrder());
        System.out.println("DFS InOrder:  [18, 21, 27, 47, 52, 76, 82]");
        System.out.println(myBST.DFSInOrder());
        // System.out.println("DFS PostOrder:  [18, 27, 21, 52, 82, 76, 47]");
        // System.out.println(myBST.DFSPostOrder());

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * DFS PreOrder:
         * [47, 21, 18, 27, 76, 52, 82]
         * 
         */

    }

    private List<Integer> DFSInOrder() {
        List<Integer> res = new ArrayList<>();
        Node root = this.root;
        Stack<Node> st = new Stack<>();
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            res.add(root.value);
            // System.out.println(root.value);
            root = root.right;
        }
        return res;
    }

    //TODO: do later for preorder and post order


}
