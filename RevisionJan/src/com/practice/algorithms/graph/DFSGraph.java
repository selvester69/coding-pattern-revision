package com.practice.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

public class DFSGraph {

    public static void dfs(List<List<Integer>> adj, int source) {
        boolean[] visited = new boolean[adj.size()];
        dfs_rec(adj, visited, source);

    }

    public static void dfs_rec(List<List<Integer>> adj, boolean[] visited, int source) {
        visited[source] = true;
        System.out.println(source + "  ");
        for (int it : adj.get(source)) {
            if (!visited[it]) {
                dfs_rec(adj, visited, it);
            }
        }
    }

    // Function to add an edge to the adjacency list
    static void addEdge(List<List<Integer>> adj, int s, int t) {
        // Add edge from vertex s to t
        adj.get(s).add(t);
        // Due to undirected Graph
        adj.get(t).add(s);
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices in the graph

        // Create an adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Define the edges of the graph
        int[][] edges = { { 1, 2 }, { 1, 0 }, { 2, 0 }, { 2, 3 }, { 2, 4 } };

        // Populate the adjacency list with edges
        for (int[] e : edges) {
            addEdge(adj, e[0], e[1]);
        }

        int source = 1;
        System.out.println("DFS from source: " + source);
        dfs(adj, source);
    }

}
