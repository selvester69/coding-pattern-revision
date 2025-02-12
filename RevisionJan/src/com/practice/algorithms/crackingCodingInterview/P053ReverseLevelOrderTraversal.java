package com.practice.algorithms.crackingCodingInterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class P053ReverseLevelOrderTraversal {

    // try to solve using both BFS and DFS

    public static List<List<Integer>> reverseLevelTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        Stack<List<Integer>> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                st.add(ans);
                ans = new ArrayList<>();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                ans.add(temp.val);
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
        }
        while (!st.isEmpty()) {
            res.add(st.pop());
        }
        return res;
    }

}
