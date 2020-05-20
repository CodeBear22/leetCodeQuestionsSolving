package com.kunal.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//56. Merge Intervals
//Given a collection of intervals, merge all overlapping intervals.
//Input: [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
public class MergeIntervals {

    /**
     * leetCode 56
     *
     * @param intervals
     * @return
     */
    public int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1)
            return intervals;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> result = new ArrayList<>();

        result.add(intervals[0]);
        int previousIndex = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] temp = result.get(previousIndex);

            if (temp[1] >= intervals[i][0] && temp[1] < intervals[i][1]) {
                temp[1] = intervals[i][1];
                result.set(previousIndex, temp);
            } else if (temp[1] < intervals[i][0]) {
                result.add(intervals[i]);
                previousIndex++;
            }
        }
        int[][] rr = new int[result.size()][2];
        return result.toArray(rr);
    }
}
