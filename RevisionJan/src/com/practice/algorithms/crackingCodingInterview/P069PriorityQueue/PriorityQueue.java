package com.practice.algorithms.crackingCodingInterview.P069PriorityQueue;

import java.util.List;

public class PriorityQueue {
    List<Integer> pq;

    public PriorityQueue() {

    }

    boolean isEmpty() {
        return this.pq.size() == 0;
    }

    int getSize() {
        return this.pq.size();
    }

    int getMin() {
        if (!this.isEmpty()) {
            return this.pq.get(0);
        }
        return -1;
    }

    void insert(int val) {
        // insert at the end
        this.pq.add(val);
        int cI = this.pq.size() - 1;
        while (cI > 0) {
            int pI = (cI - 1) / 2;// parent index
            if (this.pq.get(pI) > this.pq.get(cI)) {
                int temp = this.pq.get(pI);
                this.pq.set(pI, this.pq.get(cI));
                this.pq.set(cI, temp);
                cI = pI;
            } else {
                break;
            }
        }
    }

    int removeMin() {
        // to remove min copy the last element to first element
        if (this.pq.isEmpty()) {
            return -1;
        }
        int temp = this.pq.get(0);
        this.pq.set(0, this.pq.get(this.pq.size() - 1));
        sinkdown(0);
        return temp;
    }

    public void sinkdown(int index) {
        while (true) {
            int cI1 = index * 2 + 1;
            int cI2 = index * 2 + 2;
            int minIndex = index;
            if (cI1 < pq.size() && this.pq.get(cI1) < this.pq.get(minIndex)) {
                minIndex = cI1;
            }
            if (cI2 < pq.size() && this.pq.get(cI2) < this.pq.get(minIndex)) {
                minIndex = cI2;
            }
            if (minIndex != index) {
                int temp = this.pq.get(minIndex);
                this.pq.set(minIndex, this.pq.get(index));
                this.pq.set(index, temp);
            } else {
                break;
            }
        }
    }

}
