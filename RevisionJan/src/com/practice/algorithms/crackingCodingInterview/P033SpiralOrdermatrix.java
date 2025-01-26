package com.practice.algorithms.crackingCodingInterview;

import java.util.ArrayList;
import java.util.List;

public class P033SpiralOrdermatrix {

    List<Integer> testMethos(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int rowS = 0, colS = 0, rowE = m - 1, colE = n - 1;
        int count = 0;
        while (rowS <= rowE && colS <= colE) {
            for (int i = colS; i <= colE; i++) {
                res.add(matrix[rowS][i]);
                count++;
            }
            rowS++;
            if (count == m * n) {
                return res;
            }
            for (int i = rowS; i <= rowE; i++) {
                res.add(matrix[i][colE]);
            }
            colE--;
            if (count == m * n) {
                return res;
            }
            for (int i = colE; i >= colS; i--) {
                res.add(matrix[rowE][i]);
                count++;
            }
            rowE--;
            if (count == m * n) {
                return res;
            }
            for (int i = rowE; i >= rowS; i--) {
                res.add(matrix[i][colS]);
                count++;
            }
            colS++;
            if (count == m * n) {
                return res;
            }
        }
        return res;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int rowS = 0, colS = 0, rowE = m - 1, colE = n - 1;
        int count = 0;
        while (rowS <= rowE && colS <= colE) {

            // horizontal row traverse
            for (int i = colS; i <= colE; i++) {
                res.add(matrix[rowS][i]);
                count++;
            }
            rowS++;
            if (count == m * n)
                return res;
            // vertical col traverse
            for (int j = rowS; j <= rowE; j++) {
                res.add(matrix[j][colE]);
                count++;
            }
            colE--;
            if (count == m * n)
                return res;

            // row traverse reverse
            for (int i = colE; i >= colS; i--) {
                res.add(matrix[rowE][i]);
                count++;
            }
            rowE--;
            if (count == m * n)
                return res;
            // col traverse reverse
            for (int j = rowE; j >= rowS; j--) {
                res.add(matrix[j][colS]);
                count++;
            }
            colS++;
            if (count == m * n)
                return res;
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = spiralOrder(new int[][] { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } });
        System.out.println(res);
        res = spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } });
        System.out.println(res + " [1,2,3,4,8,12,11,10,9,5,6,7]");
    }
}
