package com.kunal.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */
public class NumberOfIslands {


    public int numIslands(char[][] grid) {


        if (grid.length == 0)
            return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int[] startFrom = {i, j};
                if (grid[i][j] != '0' && !visited[i][j] && _numIslands(grid, startFrom, visited))
                    count++;
            }
        }

        return count;

    }

    private boolean _numIslands(char[][] map, int[] startFrom, boolean[][] visited) {

        Queue<int[]> toBeProcessed = new LinkedList<>();
//        Set<String> processed = new HashSet<>();
        toBeProcessed.add(startFrom);

        while (!toBeProcessed.isEmpty()) {

            int[] current = toBeProcessed.poll();

            if (!visited[current[0]][current[1]]) {

                //Down
                int[] down = current.clone();
                down[0]++;
                if (_checkIndex(map, down)) {
                    toBeProcessed.add(down);
                }

                //Up
                int[] up = current.clone();
                up[0]--;
                if (_checkIndex(map, up)) {
                    toBeProcessed.add(up);
                }

                //Right
                int[] right = current.clone();
                right[1]++;
                if (_checkIndex(map, right)) {
                    toBeProcessed.add(right);
                }

                //Left
                int[] left = current.clone();
                left[1]--;
                if (_checkIndex(map, left)) {
                    toBeProcessed.add(left);
                }
//                processed.add(_indexToString(current));
                visited[current[0]][current[1]] = true;
            }
        }
        return true;
    }

    private String _indexToString(int[] index) {
        if (index.length != 2)
            return "";

        return index[0] + "-" + index[1];
    }

    private int[] _stringToIndex(String indexName) {
        String[] indexInString = indexName.split("-");

        return new int[]{Integer.parseInt(indexInString[0]), Integer.parseInt(indexInString[1])};
    }

    private boolean _checkIndex(char[][] board, int[] index) {

        return index[0] >= 0
                && index[0] < board.length
                && index[1] >= 0
                && index[1] < board[0].length
                && board[index[0]][index[1]] != '0';
    }
}
