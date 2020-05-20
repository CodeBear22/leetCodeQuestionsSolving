package com.kunal.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 *
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [2,3]
 */
public class FindAllDuplicatesInAnArray {
    /**
     * leetCode 442
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> result = new ArrayList<>();
        int index;
        for (int i = 0; i < nums.length; i++) {
            index = nums[i] < 0 ? (-1 * nums[i]) - 1 : nums[i] - 1;

            if (nums[index] < 0)
                result.add(nums[i] < 0 ? -1 * nums[i] : nums[i]);

            nums[index] = -nums[index];
        }
        return result;
    }
}
