package com.kunal.leetcode;


import java.util.HashMap;

/**
 * 207. Course Schedule
 * <p>
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should
 * also have finished course 1. So it is impossible.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 * 1 <= numCourses <= 10^5
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {


        boolean[][] courseGrid = new boolean[numCourses][numCourses];

        for (int[] prerequisite : prerequisites)
            courseGrid[prerequisite[0]][prerequisite[1]] = true;

//        for(boolean[] row : courseGrid)
//            System.out.println(Arrays.toString(row));

        boolean[] visited = new boolean[numCourses];

        HashMap<Integer, Boolean> overall = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (!_canFinishHelper(courseGrid, visited, i, numCourses, overall))
                    return false;
            }
        }
        return true;
    }

    private boolean _canFinishHelper(boolean[][] courseGrid, boolean[] visited, int startFrom, int totalCourse, HashMap<Integer, Boolean> overall) {

        if (visited[startFrom])
            return false;

        if (overall.containsKey(startFrom))
            return overall.get(startFrom);

        visited[startFrom] = true;

        for (int i = 0; i < totalCourse; i++) {

            if (courseGrid[startFrom][i]) {
                boolean result = _canFinishHelper(courseGrid, visited, i, totalCourse, overall);
                overall.put(i, result);
                if (!result) return false;
            }
        }
        visited[startFrom] = false;
        return true;
    }
}
