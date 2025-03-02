package com.practice.algorithms.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFSCycleDetectionGraph {

    public static boolean isCyclic(List<List<Integer>> adj) {
        Set<Integer> hs = new HashSet<>();
        int V = adj.size();
        boolean[] recStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!hs.contains(i) && isCycleUtil(adj, hs, i, recStack)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCycleUtil(List<List<Integer>> adj, Set<Integer> hs, int source, boolean[] recStack) {
        if (hs.contains(source)) {
            return true;
        }
        recStack[source] = true;
        hs.add(source);
        for (int it : adj.get(source)) {
            if (!hs.contains(it) && isCycleUtil(adj, hs, it, recStack)) {
                return true;
            }else if(recStack[it]==true){
                return true;
            }
        }
        recStack[source] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Adding edges to the graph
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(3);

        // Function call to check for cycle
        if (isCyclic(adj))
            System.out.println("Contains cycle");
        else
            System.out.println("No Cycle");
    }
}
