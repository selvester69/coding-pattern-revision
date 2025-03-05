package com.practice.algorithms.crackingCodingInterview;

import java.util.Arrays;

public class P086KruskalAlgo {

    // find minimum spanning tree.
    // 1. sort the edge
    // 2. pick the smallest egdes and edge should not make cycle
    public int isCycle(int[][] edges, int V) {
        Arrays.sort(edges, (e1, e2) -> e2[2] - e1[2]);
        DSU dsu = new DSU(V);
        int cost = 0, count = 0;
        for (int[] e : edges) {
            int x = e[0], y = e[1], w = e[2];
            if (dsu.find(x) != dsu.find(y)) {
                dsu.makeSet(x, y);
                cost += w;
                if (++count == V - 1) {
                    break;
                }
            }
        }
        return cost;
    }
}

class DSU {
    int[] parent, rank;

    public DSU(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (i != parent[i]) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void makeSet(int x, int y) {
        int s1 = find(x);
        int s2 = find(y);
        if (s1 != s2) {
            if (rank[s1] < rank[s2]) {
                parent[s1] = s2;
            } else if (rank[s1] > rank[s2]) {
                parent[s2] = s1;
            } else {
                parent[s2] = s1;
                rank[s1]++;
            }
        }
    }
}
