package com.practice.algorithms.binarySearch;

public class P17SearchInRowColumnwiseMatrix {

    public int search(int[][] matrix, int key) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i >= 0 && i < m && j >= 0 && j < n) {
            if (matrix[i][j] == key) {
                return matrix[i][j];
            } else if (matrix[i][j] < key) {
                j--;
            } else {
                i++;
            }
        }
        return -1;
    }

}
