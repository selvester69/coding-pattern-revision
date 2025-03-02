package com.practice.algorithms.crackingCodingInterview;

// this problem is related to dfs to find number of connected components in graph

public class P082NumberOfIsland {

    int numberOfIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0')
            return;
        if (visited[i][j] == true)
            return;
        visited[i][j] = true;
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j - 1, visited);
        dfs(grid, i, j + 1, visited);
        dfs(grid, i + 1, j, visited);

    }

    /**
     * without using visited array
     * 
     */
    int numberOfIslands_no_visited(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs_no_visited(grid, i, j);
                }
            }
        }
        return count;
    }

    void dfs_no_visited(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs_no_visited(grid, i - 1, j);
        dfs_no_visited(grid, i, j - 1);
        dfs_no_visited(grid, i, j + 1);
        dfs_no_visited(grid, i + 1, j);

    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        P082NumberOfIsland obj = new P082NumberOfIsland();
        int res = obj.numberOfIslands(grid);
        System.out.println(res);
        res = obj.numberOfIslands_no_visited(grid);
        System.out.println(res);
    }
}
