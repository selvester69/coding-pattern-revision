package com.practice.algorithms.backtrack;

import java.util.Arrays;

public class P09SudokuSolver {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    private boolean helper(char[][] board, int row, int col) {
        // if row is 9 means we have reached the end
        if (row == 9)
            return true;
        // if col is 9 we have to check in another row
        if (col == 9)
            return helper(board, row + 1, 0);
        // if . is not present in grid value skip and check next
        if (board[row][col] != '.') {
            return helper(board, row, col + 1);
        }
        // now it means we have . try to fill some value and proceed or revert and try
        // another value
        for (char i = '1'; i <= '9'; i++) {
            if (isValid(board, row, col, i)) {
                board[row][col] = i;
                boolean res = helper(board, row, col + 1);
                if (res) {
                    return true;
                }
            }
        }
        board[row][col] = '.';
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        // check in row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }
        // check in col
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        // check in grid
        for (int i = 0; i < (row / 3) * 3; i++) {
            for (int j = 0; j < (col / 3) * 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printBoard(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            System.out.println("Invalid board dimensions.");
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean equalsBoard(char[][] b1, char[][] b2) {
        if (b1 == null || b2 == null)
            return b1 == b2;
        if (b1.length != b2.length || b1[0].length != b2[0].length)
            return false;
        for (int i = 0; i < b1.length; i++) {
            if (!Arrays.equals(b1[i], b2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P09SudokuSolver solution = new P09SudokuSolver();
        System.out.println("=== LeetCode Test Cases ===\n");

        // Test Case 1: Standard Sudoku example from LeetCode
        System.out.println("Test Case 1: Standard Sudoku example");
        char[][] board1 = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        char[][] expected1 = {
                { '5', '3', '4', '6', '7', '8', '9', '1', '2' },
                { '6', '7', '2', '1', '9', '5', '3', '4', '8' },
                { '1', '9', '8', '3', '4', '2', '5', '6', '7' },
                { '8', '5', '9', '7', '6', '1', '4', '2', '3' },
                { '4', '2', '6', '8', '5', '3', '7', '9', '1' },
                { '7', '1', '3', '9', '2', '4', '8', '5', '6' },
                { '9', '6', '1', '5', '3', '7', '2', '8', '4' },
                { '2', '8', '7', '4', '1', '9', '6', '3', '5' },
                { '3', '4', '5', '2', '8', '6', '1', '7', '9' }
        };
        System.out.println("Input Board:");
        printBoard(board1);
        System.out.println();
        solution.solveSudoku(board1);
        System.out.println("Expected Solution:");
        printBoard(expected1);
        System.out.println("Actual Solution:");
        printBoard(board1);
        System.out.println("Result: " + (equalsBoard(board1, expected1) ? "✓ PASS" : "✗ FAIL"));
        System.out.println();

        // Test Case 2: A more complex puzzle with many empty cells
        System.out.println("Test Case 2: Complex puzzle");
        char[][] board2 = {
                { '.', '.', '9', '7', '4', '8', '.', '.', '.' },
                { '7', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '2', '.', '1', '.', '9', '.', '.', '.' },
                { '.', '.', '7', '.', '.', '.', '2', '4', '.' },
                { '.', '6', '4', '.', '1', '.', '5', '9', '.' },
                { '.', '9', '8', '.', '.', '.', '3', '.', '.' },
                { '.', '.', '.', '8', '.', '3', '.', '2', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '6' },
                { '.', '.', '.', '2', '7', '5', '9', '.', '.' }
        };
        char[][] expected2 = {
                { '1', '3', '9', '7', '4', '8', '6', '5', '2' },
                { '7', '4', '5', '3', '2', '6', '9', '1', '8' },
                { '8', '2', '6', '1', '5', '9', '4', '7', '3' },
                { '3', '5', '7', '6', '8', '1', '2', '4', '9' },
                { '2', '6', '4', '9', '1', '7', '5', '9', '4' },
                { '4', '9', '8', '5', '6', '2', '3', '7', '1' },
                { '9', '1', '3', '8', '6', '4', '7', '2', '5' },
                { '5', '7', '2', '4', '9', '3', '1', '8', '6' },
                { '6', '8', '1', '2', '7', '5', '9', '3', '4' }
        };
        System.out.println("Input Board:");
        printBoard(board2);
        System.out.println();
        solution.solveSudoku(board2);
        System.out.println("Expected Solution:");
        printBoard(expected2);
        System.out.println("Actual Solution:");
        printBoard(board2);
        System.out.println("Result: " + (equalsBoard(board2, expected2) ? "✓ PASS" : "✗ FAIL"));
        System.out.println();

        // Test Case 3: A puzzle with a large number of pre-filled cells
        System.out.println("Test Case 3: Board with many pre-filled cells");
        char[][] board3 = {
                { '8', '3', '5', '4', '1', '6', '9', '2', '7' },
                { '2', '9', '6', '8', '5', '7', '4', '3', '1' },
                { '4', '1', '7', '2', '9', '3', '6', '5', '8' },
                { '5', '6', '9', '1', '3', '4', '7', '8', '2' },
                { '1', '2', '3', '6', '7', '8', '5', '4', '9' },
                { '7', '4', '8', '5', '2', '9', '1', '6', '3' },
                { '9', '5', '2', '3', '8', '1', '0', '7', '4' }, // intentionally left a '0' to be replaced
                { '6', '8', '1', '7', '4', '2', '3', '9', '5' },
                { '3', '7', '4', '9', '6', '5', '2', '1', '8' }
        };
        char[][] expected3 = {
                { '8', '3', '5', '4', '1', '6', '9', '2', '7' },
                { '2', '9', '6', '8', '5', '7', '4', '3', '1' },
                { '4', '1', '7', '2', '9', '3', '6', '5', '8' },
                { '5', '6', '9', '1', '3', '4', '7', '8', '2' },
                { '1', '2', '3', '6', '7', '8', '5', '4', '9' },
                { '7', '4', '8', '5', '2', '9', '1', '6', '3' },
                { '9', '5', '2', '3', '8', '1', '8', '7', '4' },
                { '6', '8', '1', '7', '4', '2', '3', '9', '5' },
                { '3', '7', '4', '9', '6', '5', '2', '1', '8' }
        };
        System.out.println("Input Board:");
        printBoard(board3);
        System.out.println();
        solution.solveSudoku(board3);
        System.out.println("Expected Solution:");
        printBoard(expected3);
        System.out.println("Actual Solution:");
        printBoard(board3);
        System.out.println("Result: " + (equalsBoard(board3, expected3) ? "✓ PASS" : "✗ FAIL"));
        System.out.println();

        // Test Case 4: Puzzle with a few cells to be filled
        System.out.println("Test Case 4: Almost solved puzzle");
        char[][] board4 = {
                { '1', '2', '3', '4', '5', '6', '7', '8', '.' },
                { '4', '5', '6', '7', '8', '9', '1', '2', '3' },
                { '7', '8', '9', '1', '2', '3', '4', '5', '6' },
                { '2', '3', '4', '5', '6', '7', '8', '9', '1' },
                { '5', '6', '7', '8', '9', '1', '2', '3', '4' },
                { '8', '9', '1', '2', '3', '4', '5', '6', '7' },
                { '3', '4', '5', '6', '7', '8', '9', '1', '2' },
                { '6', '7', '8', '9', '1', '2', '3', '4', '5' },
                { '9', '1', '2', '3', '4', '5', '6', '7', '8' }
        };
        char[][] expected4 = {
                { '1', '2', '3', '4', '5', '6', '7', '8', '9' },
                { '4', '5', '6', '7', '8', '9', '1', '2', '3' },
                { '7', '8', '9', '1', '2', '3', '4', '5', '6' },
                { '2', '3', '4', '5', '6', '7', '8', '9', '1' },
                { '5', '6', '7', '8', '9', '1', '2', '3', '4' },
                { '8', '9', '1', '2', '3', '4', '5', '6', '7' },
                { '3', '4', '5', '6', '7', '8', '9', '1', '2' },
                { '6', '7', '8', '9', '1', '2', '3', '4', '5' },
                { '9', '1', '2', '3', '4', '5', '6', '7', '8' }
        };
        System.out.println("Input Board:");
        printBoard(board4);
        System.out.println();
        solution.solveSudoku(board4);
        System.out.println("Expected Solution:");
        printBoard(expected4);
        System.out.println("Actual Solution:");
        printBoard(board4);
        System.out.println("Result: " + (equalsBoard(board4, expected4) ? "✓ PASS" : "✗ FAIL"));
        System.out.println();

        // Test Case 5: Empty board (not a realistic test for Sudoku, but good for edge
        // cases)
        System.out.println("Test Case 5: A very sparse board");
        char[][] board5 = {
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' }
        };
        // We cannot provide a deterministic "expected" solution for a blank board since
        // there are many possibilities.
        // The problem statement guarantees a unique solution for the input. So this
        // test case is for illustrative purposes.
        System.out.println("Input Board:");
        printBoard(board5);
        System.out.println();
        System.out.println(
                "Note: This is an invalid test case based on problem constraints. The solution will not be checked.");
        solution.solveSudoku(board5);
        System.out.println("Actual Solution (filled):");
        printBoard(board5);
        System.out.println();

        System.out.println("=== All test cases completed ===");
    }
}
