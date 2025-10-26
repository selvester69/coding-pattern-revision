import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    /**
     * Given the root of a binary tree, return the level order traversal of its
     * nodes' values.
     * (i.e., from left to right, level by level).
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        List<Integer> level = new ArrayList();
        while (!q.isEmpty()) {
            int size = q.size();
            whil
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (temp == null) {
                    break;
                }
                level.add(temp.val);
                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);
            }
            res.add(level);
            level.clear();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("=== LeetCode Test Cases ===\n");

        // Helper method to create TreeNode from array
        // Example: [3,9,20,null,null,15,7]
        // This is a simplified way to create a tree for testing purposes.
        // It does not handle all possible cases, but works for the provided examples.
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        // Test Case 1: Example from problem description
        System.out.println("Test Case 1: Standard binary tree");
        List<List<Integer>> expected1 = new ArrayList<>();
        expected1.add(Arrays.asList(3));
        expected1.add(Arrays.asList(9, 20));
        expected1.add(Arrays.asList(15, 7));
        List<List<Integer>> result1 = solution.levelOrder(root1);
        System.out.println("Input: [3,9,20,null,null,15,7]");
        System.out.println("Expected: " + expected1);
        System.out.println("Actual:   " + result1);
        System.out.println("Result: " + (expected1.equals(result1) ? "✓ PASS" : "✗ FAIL"));
        System.out.println();

        // Test Case 2: Null root (edge case)
        System.out.println("Test Case 2: Null root");
        TreeNode root2 = null;
        List<List<Integer>> expected2 = new ArrayList<>();
        List<List<Integer>> result2 = solution.levelOrder(root2);
        System.out.println("Input: []");
        System.out.println("Expected: " + expected2);
        System.out.println("Actual:   " + result2);
        System.out.println("Result: " + (expected2.equals(result2) ? "✓ PASS" : "✗ FAIL"));
        System.out.println();

        // Test Case 3: Single node tree
        System.out.println("Test Case 3: Single node tree");
        TreeNode root3 = new TreeNode(1);
        List<List<Integer>> expected3 = new ArrayList<>();
        expected3.add(Arrays.asList(1));
        List<List<Integer>> result3 = solution.levelOrder(root3);
        System.out.println("Input: [1]");
        System.out.println("Expected: " + expected3);
        System.out.println("Actual:   " + result3);
        System.out.println("Result: " + (expected3.equals(result3) ? "✓ PASS" : "✗ FAIL"));
        System.out.println();

        // Test Case 4: Skewed tree (left-heavy)
        System.out.println("Test Case 4: Skewed tree (left-heavy)");
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(3);
        List<List<Integer>> expected4 = new ArrayList<>();
        expected4.add(Arrays.asList(1));
        expected4.add(Arrays.asList(2));
        expected4.add(Arrays.asList(3));
        List<List<Integer>> result4 = solution.levelOrder(root4);
        System.out.println("Input: [1,2,null,3]");
        System.out.println("Expected: " + expected4);
        System.out.println("Actual:   " + result4);
        System.out.println("Result: " + (expected4.equals(result4) ? "✓ PASS" : "✗ FAIL"));
        System.out.println();

        // Test Case 5: Skewed tree (right-heavy)
        System.out.println("Test Case 5: Skewed tree (right-heavy)");
        TreeNode root5 = new TreeNode(1);
        root5.right = new TreeNode(2);
        root5.right.right = new TreeNode(3);
        List<List<Integer>> expected5 = new ArrayList<>();
        expected5.add(Arrays.asList(1));
        expected5.add(Arrays.asList(2));
        expected5.add(Arrays.asList(3));
        List<List<Integer>> result5 = solution.levelOrder(root5);
        System.out.println("Input: [1,null,2,null,null,null,3]");
        System.out.println("Expected: " + expected5);
        System.out.println("Actual:   " + result5);
        System.out.println("Result: " + (expected5.equals(result5) ? "✓ PASS" : "✗ FAIL"));
        System.out.println();

        // Test Case 6: Larger, more complex tree
        System.out.println("Test Case 6: Larger tree with multiple levels");
        TreeNode root6 = new TreeNode(10);
        root6.left = new TreeNode(5);
        root6.right = new TreeNode(15);
        root6.left.left = new TreeNode(2);
        root6.left.right = new TreeNode(7);
        root6.right.left = new TreeNode(12);
        root6.right.right = new TreeNode(20);
        root6.left.left.left = new TreeNode(1);
        root6.left.left.right = new TreeNode(3);
        root6.left.right.left = new TreeNode(6);
        root6.left.right.right = new TreeNode(8);
        List<List<Integer>> expected6 = new ArrayList<>();
        expected6.add(Arrays.asList(10));
        expected6.add(Arrays.asList(5, 15));
        expected6.add(Arrays.asList(2, 7, 12, 20));
        expected6.add(Arrays.asList(1, 3, 6, 8));
        List<List<Integer>> result6 = solution.levelOrder(root6);
        System.out.println("Input: A complex tree structure");
        System.out.println("Expected: " + expected6);
        System.out.println("Actual:   " + result6);
        System.out.println("Result: " + (expected6.equals(result6) ? "✓ PASS" : "✗ FAIL"));
        System.out.println();

        System.out.println("=== All test cases completed ===");
    }
}