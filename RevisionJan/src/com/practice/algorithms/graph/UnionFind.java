package com.practice.algorithms.graph;

public class UnionFind {
    int[] parent;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;// initially all vertex are disjoint and has itself as representative element
        }
    }

    // find the representative of the set that includes the element i
    public int find(int i) {
        if (parent[i] == i) {
            return i;
        } else {
            return find(parent[i]);
        }
    }

    public void union(int i, int j) {
        int irep = find(i);// representative of set containing i
        int jrep = find(j); // representative of set containing j
        parent[irep] = jrep; // make the representative of i to be representative of j
    }

    public static void main(String[] args) {
        int size = 5;
        UnionFind set = new UnionFind(size);
        set.union(1, 2);
        set.union(3, 4);
        boolean isSameSet = set.find(1) == set.find(3);
        System.out.println("are 1 and 2 in same set : " + isSameSet);
    }

    // we can improve upon the find and unoin function using the 2 below approach
    // 1. path compresssion
    // 2. union by rank
    

}
