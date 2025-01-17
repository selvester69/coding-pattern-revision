package com.practice.algorithms.scottbarett.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.practice.datastructure.trees.BinarySearchTree;
import com.practice.datastructure.trees.Node;

public class BFS extends BinarySearchTree {

    public static void main(String[] args) {

        BFS myBST = new BFS();

        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);

        System.out.println("Breadth First Search:");
        System.out.println(myBST.bfs());

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * Breadth First Search:
         * [47, 21, 76, 18, 27, 52, 82]
         * 
         */

    }

    private List<Integer> bfs() {
        List<Integer> res = new ArrayList<>();
        Node temp = this.root;
        if (temp == null) {
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(temp);

        while (!q.isEmpty()) {
            Node curr = q.remove();
            res.add(curr.value);
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        return res;

    }
}
