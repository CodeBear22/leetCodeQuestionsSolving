package com.kunal.leetcode;

//78. Subsets

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {

    /**
     * leetCode 78
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {

        int totalPossibleCombination = (int) Math.pow(2, (double) nums.length);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < totalPossibleCombination; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = nums.length - 1; j >= 0; j--) {
                boolean valid = (i & (1 << j)) != 0;
                System.out.println(valid);
                if (valid) {
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }

        return result;
    }
}
