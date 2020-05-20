package com.kunal.leetcode;

//55. Jump Game
//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Determine if you are able to reach the last index.
public class JumpGame {

    /**
     * leetCode 55
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        int maxReachableIndex = nums[0];

        for (int i = 0; i < nums.length; i++) {

            if (maxReachableIndex >= nums.length - 1)
                return true;

            if (maxReachableIndex <= i && nums[i] == 0)
                return false;

            if (i + nums[i] > maxReachableIndex)
                maxReachableIndex = i + nums[i];
        }
        return false;
    }
}
