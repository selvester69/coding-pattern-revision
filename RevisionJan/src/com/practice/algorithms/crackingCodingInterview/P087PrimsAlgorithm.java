package com.practice.algorithms.crackingCodingInterview;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class P087PrimsAlgorithm {
    class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    int mst_prims(ArrayList<ArrayList<ArrayList<Integer>>> adj, int V) { // we are given a graph as adjacency list
        PriorityQueue<Pair> queue = new PriorityQueue<>((e1, e2) -> e1.distance - e2.distance);
        int[] visited = new int[V];
        queue.add(new Pair(0, 0));
        int sum = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (visited[pair.node] == 1)
                continue;

            visited[pair.node] = 1;
            sum += pair.distance;
            for (int i = 0; i < adj.get(pair.node).size(); i++) {
                int edge = adj.get(pair.node).get(i).get(1);
                int adjNode = adj.get(pair.node).get(i).get(0);
                if (visited[adjNode] != 1) {
                    queue.add(new Pair(adjNode, edge));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int[][] edges = { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 2, 1 }, { 2, 3, 2 }, { 3, 4, 1 }, { 4, 2, 2 } };

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }
        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);

        }
        int sum = new P087PrimsAlgorithm().mst_prims(adj, V);
        System.out.println("The sum of all the edge weights: " + sum);
    }

}
