package com.kunal.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//73. Set Matrix Zeroes
//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
//Input:
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//Output:
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
public class SetMatrixZeroes {

    /**
     * leetCode 73
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {

        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (Integer row : rows) {
            Arrays.fill(matrix[row], 0);
        }

        for (Integer col : cols) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
