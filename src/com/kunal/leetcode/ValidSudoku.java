package com.kunal.leetcode;

//36. Valid Sudoku
public class ValidSudoku {

    /**
     * leetCode 36
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
//        boolean result = true;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!_isValidSudokuHelper(board, board[i][j], i, j))
                        return false;
                }
            }
        }
        return true;
    }

    private boolean _isValidSudokuHelper(char[][] board, char k, int m, int n) {

        //vertical check
        for (int i = 0; i < 9; i++) {
            if (m != i && board[i][n] != '.' && board[i][n] == k)
                return false;
        }

        //horizontal check
        for (int i = 0; i < 9; i++) {
            if (n != i && board[m][i] != '.' && board[m][i] == k)
                return false;
        }

        //subMatrix check
        int startX = (m / 3) * 3;
        int startY = (n / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (!(m == i && n == j) && board[i][j] != '.' && board[i][j] == k)
                    return false;
            }
        }
        return true;
    }
}
