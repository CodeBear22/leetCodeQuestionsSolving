package com.kunal.leetcode;

import java.util.Arrays;

//48. Rotate Image
//You are given an n x n 2D matrix representing an image.
//Rotate the image by 90 degrees (clockwise).
public class RotateImage {
    /**
     * leetCode 48
     *
     * @param matrix
     */
    public void rotateMatrixNinetyDegree(int[][] matrix) {
        int n = matrix.length;
        int temp;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
