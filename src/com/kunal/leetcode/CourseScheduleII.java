package com.kunal.leetcode;

import java.util.*;

/**
 * 210. Course Schedule II
 * <p>
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * <p>
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * Example 1:
 * <p>
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 * course 0. So the correct course order is [0,1] .
 * Example 2:
 * <p>
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 * courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 * Note:
 * <p>
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> neighbours = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            List<Integer> vertexNeighbour;
            if (neighbours.containsKey(prerequisite[0])) {

                vertexNeighbour = neighbours.get(prerequisite[0]);
            } else {
                vertexNeighbour = new ArrayList<>();
            }
            vertexNeighbour.add(prerequisite[1]);
            neighbours.put(prerequisite[0], vertexNeighbour);
        }


        List<Integer> courseOrder = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visitedInPath = new HashSet<>();

        int[] result = {};

        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i)) {
                boolean callResult = _findOrderHelper(i, neighbours, courseOrder, visitedInPath, visited);
                if (!callResult)
                    return result;
            }
        }

        result = new int[numCourses];

        for (int i = 0; i < courseOrder.size(); i++) {
            result[i] = courseOrder.get(i);
        }
        return result;
    }

    private boolean _findOrderHelper(int startFrom, HashMap<Integer, List<Integer>> neighbours, List<Integer> courseOrder, Set<Integer> visitedInPath, Set<Integer> visited) {
        visitedInPath.add(startFrom);

        if (neighbours.containsKey(startFrom)) {
            for (int i : neighbours.get(startFrom)) {

                if (courseOrder.contains(i))
                    continue;

                if (visitedInPath.contains(i))
                    return false;

                boolean result = _findOrderHelper(i, neighbours, courseOrder, visitedInPath, visited);
                if (!result)
                    return false;
                else
                    visited.add(i);
            }
        }
        courseOrder.add(startFrom);
        return true;
    }
}
