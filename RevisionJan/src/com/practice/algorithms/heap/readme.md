# Heap-Based Problems and Algorithms

This document outlines a set of problems and algorithms that can be efficiently solved using heaps (priority queues). Heaps are particularly useful for problems involving finding the smallest or largest elements, maintaining sorted order in a partially sorted array, and dealing with frequency-based operations.

## Problems and Algorithms

1.  **K Smallest Elements:**
    * **Description:** Given an array of integers, find the k smallest elements.
    * **Approach:** Use a max-heap of size k. Maintain the k smallest elements seen so far in the heap.
    * **Complexity:** O(n log k)

2.  **K Largest Elements in Array:**
    * **Description:** Given an array of integers, find the k largest elements.
    * **Approach:** Use a min-heap of size k. Maintain the k largest elements seen so far in the heap.
    * **Complexity:** O(n log k)

3.  **Sort K Sorted Array:**
    * **Description:** Given an array that is k-sorted (each element is at most k positions away from its sorted position), sort the array efficiently.
    * **Approach:** Use a min-heap of size k+1. Add the first k+1 elements to the heap, then repeatedly extract the minimum and add the next element.
    * **Complexity:** O(n log k)

4.  **K Closest Numbers:**
    * **Description:** Given a sorted array, find the k closest numbers to a given target value.
    * **Approach:** Use a max-heap to store pairs of (absolute difference, number). Maintain the k closest numbers in the heap.
    * **Complexity:** O(n log k)

5.  **Top K Frequent Numbers:**
    * **Description:** Given an array of integers, find the k most frequent numbers.
    * **Approach:** Use a min-heap to store pairs of (frequency, number). Maintain the k most frequent numbers in the heap.
    * **Complexity:** O(n log k)

6.  **Frequency Sort:**
    * **Description:** Given a string, sort characters by their frequency in descending order.
    * **Approach:** Use a max-heap to store pairs of (frequency, character). Extract characters from the heap to build the sorted string.
    * **Complexity:** O(n log n)

7.  **K Closest Points to Origin:**
    * **Description:** Given a list of points, find the k closest points to the origin (0, 0).
    * **Approach:** Use a max-heap to store pairs of (distance, point). Maintain the k closest points in the heap.
    * **Complexity:** O(n log k)

8.  **Connected Ropes to Minimize the Cost:**
    * **Description:** Given a list of rope lengths, connect the ropes to minimize the total cost (cost of connecting two ropes is their sum).
    * **Approach:** Use a min-heap to store the rope lengths. Repeatedly extract the two smallest ropes, connect them, and add the result back to the heap.
    * **Complexity:** O(n log n)

9.  **Sum of Elements Between K1 Smallest and K2 Smallest Numbers:**
    * **Description:** Given an array of integers, find the sum of elements between the k1-th smallest and k2-th smallest numbers.
    * **Approach:** Use a min-heap to find the k1-th and k2-th smallest numbers. Then, iterate through the array and sum the elements between these two values.
    * **Complexity:** O(n log k2) (where k2 > k1)

## Key Concepts

* **Heaps (Priority Queues):** Data structures that efficiently maintain a partially ordered set of elements.
* **Min-Heap:** A heap where the smallest element is always at the root.
* **Max-Heap:** A heap where the largest element is always at the root.
* **Heapify:** The process of converting an array into a heap.
* **Heap Operations:** Insertion, extraction, and peeking.

## Applications

Heaps are widely used in various applications, including:

* **Scheduling algorithms**
* **Graph algorithms (Dijkstra's algorithm, Prim's algorithm)**
* **Event-driven simulations**
* **Data compression (Huffman coding)**
* **Operating systems (process scheduling)**

By understanding and applying heap-based algorithms, you can efficiently solve a wide range of problems involving ordered data and priority-based operations.