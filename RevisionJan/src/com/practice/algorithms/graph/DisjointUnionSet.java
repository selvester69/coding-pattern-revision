package com.practice.algorithms.graph;

public class DisjointUnionSet {
    int[] rank, parent;
    int n;

    public DisjointUnionSet(int n) {
        this.n = n;
        rank = new int[n];
        parent = new int[n];
        // initialize all parent
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        int root = parent[i];
        if (parent[i] != root) {
            parent[i] = find(root);
            return parent[i];
        }
        return root;
    }

    // finding union by rank
    public void union(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        if (xRoot == yRoot) {
            return;
        }
        if (rank[xRoot] < rank[yRoot]) {// if xrank is less than y rank
            parent[xRoot] = yRoot;// move x under y so that depth remains less
        } else if (rank[xRoot] > rank[yRoot]) { // else if XRank is greater than yRank
            parent[yRoot] = xRoot;// move y under x so that depth remains less
        } else { // if both are equal
            parent[yRoot] = xRoot;// move y under x (or x under y)
            rank[xRoot] = rank[xRoot] + 1;// increment rank by 1;
        }
    }

    // another way is to find union by size
    // TODO: yet to implement

    public static void main(String[] args) {
        int n = 5;
        DisjointUnionSet set = new DisjointUnionSet(n);
        set.union(0, 2);
        set.union(4, 2);
        set.union(3, 1);

        if (set.find(4) == set.find(0)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        if (set.find(1) == set.find(0)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

}
