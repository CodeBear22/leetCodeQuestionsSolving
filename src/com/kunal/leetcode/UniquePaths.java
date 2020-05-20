package com.kunal.leetcode;

//62. Unique Paths

//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//How many possible unique paths are there?
//Input: m = 3, n = 2
//Output: 3
//Explanation:
//From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//1. Right -> Right -> Down
//2. Right -> Down -> Right
//3. Down -> Right -> Right
public class UniquePaths {

    /**
     * leetcode 62
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {

        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    grid[i][j] = 1;
                else if (i == 0)
                    grid[i][j] = grid[i][j - 1];
                else if (j == 0)
                    grid[i][j] = grid[i - 1][j];
                else {
                    int comingFromUp = grid[i - 1][j];
                    int comingFromRight = grid[i][j - 1];
                    grid[i][j] = comingFromRight + comingFromUp;
                }

            }
        }
        return grid[m - 1][n - 1];
    }
}
