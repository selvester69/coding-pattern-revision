package com.practice.algorithms.crackingCodingInterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// All the graphs in topological sort are directed acyclic.
public class P084TopologicalSort {

    public List<Integer> topologicalSort_DFS() {
        List<Integer> res = new ArrayList<>();

        return res;
    }

    public int[] topologicalSort_BFS(List<List<Integer>> adjList, int V) {
        int[] res = new int[V];
        int[] indegree = new int[V];
        // count indegree of each node
        for (int i = 0; i < V; i++) {
            for (int it : adjList.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        // add nodes with indegree 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int index = 0;
        // loop through the nodes
        while (!queue.isEmpty()) {
            int u = queue.poll();
            res[index++] = u;
            for (int it : adjList.get(u)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }
        // if index and total V doesnt match it means there is cycle in graph
        if (index != V) {
            System.out.println("graph contains cycle");
            return new int[] { 0 };
        }
        return res;
    }

    public static void main(String[] args) {
        P084TopologicalSort obj = new P084TopologicalSort();
        // Number of nodes
        int n = 6;

        // Edges
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 },
                { 4, 5 }, { 5, 1 }, { 5, 2 } };

        // Graph represented as an adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Constructing adjacency list
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        // Performing topological sort
        System.out.println(
                "Topological sorting of the graph: ");
        int[] result = obj.topologicalSort_BFS(adj, n);

        // Displaying result
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
