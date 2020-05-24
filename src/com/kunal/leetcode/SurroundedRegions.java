package com.kunal.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 130. Surrounded Regions
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Example:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 * <p>
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {

        if(board.length < 3 || board[0].length < 3)
            return;

        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if(!visited[i][j] && board[i][j] != 'X')
                    _surroundedRegionsHelper(board, i, j, visited);

                visited[i][j] = true;

            }
        }

    }

    private void _surroundedRegionsHelper(char[][] board, int i, int j, boolean[][] visited) {

        Queue<int[]> indexToBeProcessed = new LinkedList<>();

        HashMap<String, Boolean> alpha = new HashMap<>();

        int[] begin = {i,j};
        indexToBeProcessed.add(begin);
        alpha.put(begin[0] + "-" + begin[1], true);

        while(!indexToBeProcessed.isEmpty()) {
            int[] index = indexToBeProcessed.poll();
            visited[index[0]][index[1]] = true;

            if(index[0] < board.length - 1
                    && index[1] < board[0].length - 1
                    && index[0] > 0
                    && index[1] > 0
            ) {


                int[] down = {index[0] + 1, index[1]};
                String downIndexKey = down[0] + "-" + down[1];

                if (!alpha.containsKey(downIndexKey) && board[index[0] + 1][index[1]] != 'X') {
                    indexToBeProcessed.add(down);
                    alpha.put(downIndexKey, true);
                }

                int[] right = {index[0], index[1] + 1};
                String rightIndexKey = right[0] + "-" + right[1];

                if (!alpha.containsKey(rightIndexKey) && board[index[0]][index[1] + 1] != 'X') {
                    indexToBeProcessed.add(right);
                    alpha.put(rightIndexKey, true);
                }

                int[] up = {index[0] - 1, index[1]};
                String upIndexKey = up[0] + "-" + up[1];

                if (!alpha.containsKey(upIndexKey) && board[index[0] - 1][index[1]] != 'X') {
                    indexToBeProcessed.add(up);
                    alpha.put(upIndexKey, true);
                }

                int[] left = {index[0], index[1] - 1};
                String leftIndexKey = left[0] + "-" + left[1];

                if (!alpha.containsKey(leftIndexKey) && board[index[0]][index[1] - 1] != 'X') {
                    indexToBeProcessed.add(left);
                    alpha.put(leftIndexKey, true);
                }
            } else {
                return;
            }
        }

        for ( String key : alpha.keySet() ) {
            String[] matrixIndex = key.split("-");
            board[Integer.parseInt(matrixIndex[0])][Integer.parseInt(matrixIndex[1])] = 'X';
        }
    }
}
