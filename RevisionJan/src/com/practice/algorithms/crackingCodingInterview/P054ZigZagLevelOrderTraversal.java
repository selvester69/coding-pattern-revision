package com.practice.algorithms.crackingCodingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P054ZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        boolean reverse = false;
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                if (reverse) {
                    Collections.reverse(ans);
                }
                res.add(ans);
                ans = new ArrayList<>();
                if (!q.isEmpty()) {
                    q.add(null);
                    reverse = !reverse;
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

    // another approach without using null is to calculate the size of q before
    // popping the element
    // and create a variable LtR to check if we need left to right or reverse.

    public List<List<Integer>> zigzagLevelOrder_2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        boolean isLtR = true;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> ans = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                int index = isLtR ? i : (size - i - 1);
                ans.add(index, temp.val);
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            isLtR = !isLtR;
            res.add(ans);
        }
        return res;
    }
    

}
