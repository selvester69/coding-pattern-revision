package com.practice.algorithms.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DisjointSetForCycleDetection {

    /**
     * makeset [create set with 1 element ]
     * union[ take 2 set and merge them into one ]
     * find [ return the representative element for that set]
     */

    public int mst_kruskal(int[][] edges, int V) {
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));
        DSU dsu = new DSU(V);
        int cost = 0, count = 0;
        for (int[] e : edges) {
            int x = e[0], y = e[1], w = e[2];
            if (dsu.find(x) != dsu.find(y)) {
                dsu.union(x, y);
                cost += w;
                if (++count == V - 1)
                    break;
            }
        }
        return cost;
    }

}

class DSU {
    int[] rank, parent;
    int n;

    DSU(int n) {
        this.n = n;
        this.rank = new int[n];
        this.parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int x, int y) {
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
