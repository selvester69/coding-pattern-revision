package com.practice.datastructure.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    protected List<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return this.heap;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = this.heap.get(index1);
        this.heap.set(index1, this.heap.get(index2));
        this.heap.set(index2, temp);
    }

    public void insert(int value) {
        this.heap.add(value);
        int index = this.heap.size() - 1;
        while (index > 0 && this.heap.get(index) < this.heap.get(parent(index))) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public Integer remove() {
        if (this.heap.size() == 0)
            return null;
        if (this.heap.size() == 1)
            return this.heap.remove(0);
        int minVal = this.heap.get(0);
        this.heap.set(0, this.heap.remove(this.heap.size() - 1));
        sinkdown(0);
        return minVal;
    }

    private void sinkdown(int index) {
        int minIndex = 0;
        while (true) {
            int left = leftChild(index);
            int right = rightChild(index);
            if (left < this.heap.size() && this.heap.get(index) > this.heap.get(left)) {
                minIndex = left;
            }
            if (right < this.heap.size() && this.heap.get(index) > this.heap.get(right)) {
                minIndex = right;
            }
            if (index != minIndex) {
                swap(index, minIndex);
                minIndex = index;
            } else {
                return;
            }
        }
    }

}
