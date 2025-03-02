package com.practice.algorithms.crackingCodingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P085CourseSchedule {
    // there are 2 approaches to solve this problem
    // first is to use dfs cycle detection
    // second is to use topological sort

    public static boolean canFinish_dfs(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = makeGraph(prerequisites, numCourses);
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && dfsCycle(adj, visited, i, recStack)) {
                return false;
            }
        }
        return true;
    }

    public static boolean dfsCycle(List<List<Integer>> adj, boolean[] visited, int n, boolean[] recStack) {
        if (visited[n]) {
            return false;
        }
        visited[n] = true;
        recStack[n] = true;
        for(int it:adj.get(n)){
            if(recStack[it]|| dfsCycle(adj, visited, it, recStack)){
                return true;
            }
        }

        recStack[n] = false;
        return false;
    }

    public static List<List<Integer>> makeGraph(int[][] pre, int n) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }
        for (int i = 0; i < pre.length; i++) {
            res.get(pre[i][1]).add(pre[i][0]);
        }
        return res;
    }

    // Approach 2 using topological sort 
    public static boolean canFinish(int numCourse, int[][] prerequisites) {
        List<List<Integer>> adj = makeGraph(prerequisites, numCourse);
        int[] indegree = new int[numCourse];
        for (int i = 0; i < adj.size(); i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourse; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int index=0;
        while (!q.isEmpty()) {
            int u = q.poll();
            index++;
            for (int it : adj.get(u)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return index==numCourse;
    }



    public static void main(String[] args) {
        

        // Test Case 1: Simple cycle
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}, {0, 1}};
        test( numCourses1, prerequisites1, false, "Test Case 1");

        // Test Case 2: No cycle
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}};
        test( numCourses2, prerequisites2, true, "Test Case 2");

        // Test Case 3: More courses, no cycle
        int numCourses3 = 4;
        int[][] prerequisites3 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        test( numCourses3, prerequisites3, true, "Test Case 3");

        // Test Case 4: More courses, cycle
        int numCourses4 = 4;
        int[][] prerequisites4 = {{1, 0}, {2, 0}, {3, 1}, {0, 3}};
        test( numCourses4, prerequisites4, false, "Test Case 4");

        // Test Case 5: Empty prerequisites
        int numCourses5 = 3;
        int[][] prerequisites5 = {};
        test( numCourses5, prerequisites5, true, "Test Case 5");

        // Test Case 6: Single course, no prerequisites
        int numCourses6 = 1;
        int[][] prerequisites6 = {};
        test( numCourses6, prerequisites6, true, "Test Case 6");

        // Test Case 7: Larger number of courses, no cycle
        int numCourses7 = 10;
        int[][] prerequisites7 = {{5, 8}, {3, 5}, {1, 9}, {4, 5}, {0, 2}, {1, 9}, {7, 8}, {4, 9}};
        test( numCourses7, prerequisites7, true, "Test Case 7");

        // Test Case 8: Larger number of courses, cycle
        int numCourses8 = 10;
        int[][] prerequisites8 = {{5, 8}, {3, 5}, {1, 9}, {4, 5}, {0, 2}, {1, 9}, {7, 8}, {4, 9}, {8,3}};
        test( numCourses8, prerequisites8, false, "Test Case 8");

        // Test case 9: Self loop
        int numCourses9 = 2;
        int[][] prerequisites9 = {{0,0}};
        test( numCourses9, prerequisites9, false, "Test Case 9");

        //Test case 10: One node with many prerequisites.
        int numCourses10 = 5;
        int[][] prerequisites10 = {{4,0},{4,1},{4,2},{4,3}};
        test(numCourses10, prerequisites10, true, "Test Case 10");

    }

    private static void test(int numCourses, int[][] prerequisites, boolean expected, String testName) {
        boolean actual = canFinish(numCourses, prerequisites);
        System.out.println(testName + ": " + (actual == expected ? "Passed" : "Failed"));
        if (actual != expected) {
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            System.out.println("numCourses: " + numCourses);
            System.out.println("prerequisites: " + Arrays.deepToString(prerequisites));
        }
    }
}
