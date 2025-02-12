package com.practice.algorithms.crackingCodingInterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P052LevelOrderTraversal {

    // to group nodes as each level try to leverage null

    public static List<List<Integer>> levelTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                res.add(ans);
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
        return res;
    }

}
