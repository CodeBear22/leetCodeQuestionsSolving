package com.kunal.leetcode;

import java.util.ArrayList;
import java.util.List;

//54. Spiral Matrix
//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
public class SpiralMatrix {

    /**
     * leetCode 54
     *
     * @param matrix
     * @return
     */
    public List<Integer> printMatrixInSpiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0)
            return result;

        int rowStart = 0, colStart = 0, rowEnd = matrix.length, colEnd = matrix[0].length;

        while (rowStart < rowEnd && colStart < colEnd) {
            for (int i = colStart; i < colEnd; i++)
                result.add(matrix[rowStart][i]);
            rowStart++;

            for (int i = rowStart; i < rowEnd; i++)
                result.add(matrix[i][colEnd - 1]);
            colEnd--;

            if (rowStart < rowEnd) {
                for (int i = colEnd - 1; i >= colStart; i--)
                    result.add(matrix[rowEnd - 1][i]);
                rowEnd--;
            }

            if (colStart < colEnd) {
                for (int i = rowEnd - 1; i >= rowStart; i--)
                    result.add(matrix[i][colStart]);
                colStart++;
            }
        }
        return result;
    }
}
