package com.practice.algorithms.crackingCodingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P088CommutableIslands {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        PriorityQueue<Pair> q = new PriorityQueue<Pair>((a, b) -> a.wt - b.wt);
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < B.size(); i++) {
            int u = B.get(i).get(0);
            int v = B.get(i).get(1);
            int wt = B.get(i).get(2);
            adj.get(u-1).add(new Pair(v-1, wt));
            adj.get(v-1).add(new Pair(u-1, wt));
        }
        q.add(new Pair(0, 0));
        int visited[] = new int[A];
        int sum = 0;
        while (!q.isEmpty()) {
            Pair node = q.poll();
            if (visited[node.v] == 1)
                continue;
            visited[node.v] = 1;
            sum += node.wt;
            for (Pair it : adj.get(node.v)) {
                if (visited[it.v] == 0) {
                    q.add(new Pair(it.v, it.wt));
                }
            }
        }
        return sum;
    }

    class Pair {
        int v;
        int wt;

        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        // Create the outer List
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();

        // Add the inner Lists (rows)
        B.add(new ArrayList<>(Arrays.asList(1, 2, 1)));
        B.add(new ArrayList<>(Arrays.asList(2, 3, 4)));
        B.add(new ArrayList<>(Arrays.asList(1, 4, 3)));
        B.add(new ArrayList<>(Arrays.asList(4, 3, 2)));
        B.add(new ArrayList<>(Arrays.asList(1, 3, 10)));

        // Print the List (for verification)
        System.out.println(B);
        int A = 4;
        P088CommutableIslands obj = new P088CommutableIslands();
        System.out.println(obj.solve(A, B));
    }
}
