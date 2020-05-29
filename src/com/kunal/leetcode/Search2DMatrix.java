package com.kunal.leetcode;

/**
 * 74. Search a 2D Matrix
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0)
            return false;
        int totalElements = matrix.length * matrix[0].length;
        if (totalElements == 0)
            return false;

        int totalColumns = matrix[0].length;
        int left = 0;
        int right = totalElements - 1;
        int row;
        int column;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            row = mid / totalColumns;
            column = mid % totalColumns;

            System.out.println(matrix[row][column] + "--" + mid + "--" + row + "--" + column);

            if (target == matrix[row][column])
                return true;

            if (target > matrix[row][column]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
