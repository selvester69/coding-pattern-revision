package com.practice.algorithms.heap;

import java.util.PriorityQueue;

public class P07KClosestPointToOrigin {

    class Pair {
        int dist;
        int[] point;

        public Pair(int dist, int[] point) {
            this.dist = dist;
            this.point = point;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.dist - a.dist);
        for (int i = 0; i < points.length; i++) {
            int dist = (int)(Math.pow(points[i][0],2) + Math.pow(points[i][1],2));
            pq.add(new Pair(dist, points[i]));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int index=0;
        while(pq.size()>0){
            Pair p = pq.poll();
            res[index++]= p.point;
        }
        return res;
    }
}
