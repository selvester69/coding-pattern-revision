package com.practice.datastructure.heap;

import java.util.ArrayList;
import java.util.List;

//Implementation of heap with MAX-HEAP property.

public class MaxHeap {
    private List<Integer> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return this.heap;
    }

    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    public int parent(int child) {
        return (child - 1) / 2;
    }

    public void swap(int index1, int index2) {
        int temp = this.heap.get(index1);
        this.heap.set(index1, this.heap.get(index2));
        this.heap.set(index2, temp);
    }

    public void insert(int value) {
        this.heap.add(value);
        int insertIndex = this.heap.size() - 1;
        while (insertIndex > 0 && this.heap.get(insertIndex) > this.heap.get(this.parent(insertIndex))) {
            swap(insertIndex, parent(insertIndex));
            insertIndex = parent(insertIndex);
        }
    }

    public Integer remove() {
        if (this.heap.size() == 0)
            return null;
        if (this.heap.size() == 1)
            return this.heap.remove(0);
        int val = this.heap.get(0);
        this.heap.set(0, this.heap.remove(this.heap.size() - 1));
        this.sinkDown(0);
        return val;
    }

    private void sinkDown(int index) {
        int maxIndex = index;
        while (true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }

            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }

            if (maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }
        }

    }

}
