package com.kunal.leetcode;

//11. Container With Most Water
//Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
//Note: You may not slant the container and n is at least 2.
public class ContainerWithMostWater {


    /**
     * LeetCode 11
     *
     * @param heights //int[]
     * @return int
     */
    public int largestRectangleArea(int[] heights) {

        int left = 0, right = heights.length - 1;
        if (right == 0) {
            return 0;
        }

        int maxArea = 0, currentArea, minHeight;

        while (left < right) {
            minHeight = Math.min(heights[left], heights[right]);
            currentArea = minHeight * (right - left);
            maxArea = Math.max(currentArea, maxArea);

            while (left < right && heights[left] <= minHeight) left++;

            while (left < right && heights[right] <= minHeight) right--;
        }
        return maxArea;
    }
}
