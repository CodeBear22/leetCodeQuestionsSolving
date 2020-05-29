package com.kunal.leetcode;


/**
 * 240. Search a 2D Matrix II
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * <p>
 * Given target = 20, return false.
 */
public class Search2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {

        int i = matrix.length - 1;
        int j = 0;

        while (i >= 0 && j < matrix[0].length) {
            if (target == matrix[i][j])
                return true;
            if (target < matrix[i][j])
                i--;
            else if (target > matrix[i][j])
                j++;

        }
        return false;
    }
}
