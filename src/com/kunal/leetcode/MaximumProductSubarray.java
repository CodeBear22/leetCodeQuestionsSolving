package com.kunal.leetcode;

/**
 * 152. Maximum Product Subarray
 * <p>
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p>
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {

        int currentMin = nums[0];
        int currentMax = nums[0];
        int finalMax = nums[0];
        int temp;

        for (int i = 1; i < nums.length; i++) {

            temp = currentMax;

            currentMax = Math.max(Math.max(currentMax * nums[i], currentMin * nums[i]), nums[i]);
            currentMin = Math.min(Math.min(temp * nums[i], currentMin * nums[i]), nums[i]);

            if (finalMax < currentMax)
                finalMax = currentMax;
        }
        return finalMax;
    }
}
