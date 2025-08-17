package com.practice.algorithms.leetcode;

public class Leetcode73 {

    public static void setZeroes(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int[][] mark = new int[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            System.arraycopy(matrix[r], 0, mark[r], 0, COLS);
        }
        printMatrix(mark);
        
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (mark[r][c] == 0) {
                    for (int col = 0; col < COLS; col++) {
                        matrix[r][col] = 0;
                    }
                    for (int row = 0; row < ROWS; row++) {
                        matrix[row][c] = 0;
                    }
                }
            }
        }
        printMatrix(matrix);

        // for (int r = 0; r < ROWS; r++) {
        //     System.arraycopy(mark[r], 0, matrix[r], 0, COLS);
        // }
    }

    public static void printMatrix(int[][] matrix) {
        // Loop through each row
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("["); // Start of the row
            // Loop through each element in the current row
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                // Add a comma and space if it's not the last element
                if (j < matrix[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]"); // End of the row, move to next line
        }
    }

    public static void main(String[] args) {
        // Example usage:
        int[][] myMatrix = {
                { 1, 2, 3 },
                { 4, 0, 6 },
                { 7, 8, 0 }
        };

        System.out.println("My Matrix:");
        // printMatrix(myMatrix);
        setZeroes(myMatrix);
    }

}
