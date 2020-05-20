package com.kunal.leetcode;

/**
 * 79. Word Search
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 *
 * Constraints:
 *
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class WordSearch {

    /**
     * leetCode 79
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] charArr = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (_existHelper(board, charArr, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean _existHelper(char[][] board, char[] word, int currentIndex, int row, int col) {

        if (currentIndex == word.length)
            return true;

        if (row < 0
                || row >= board.length
                || col < 0
                || col >= board[0].length
                || board[row][col] != word[currentIndex]
        )
            return false;

//        char temp = board[row][col];
        board[row][col] ^= 256;
        boolean result = _existHelper(board, word, currentIndex + 1, row + 1, col)
                || _existHelper(board, word, currentIndex + 1, row, col + 1)
                || _existHelper(board, word, currentIndex + 1, row, col - 1)
                || _existHelper(board, word, currentIndex + 1, row - 1, col);
        board[row][col] ^= 256;
        return result;
    }
}
