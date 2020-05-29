package com.kunal.leetcode;

/**
 * 238. Product of Array Except Self
 * <p>
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 * <p>
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int[] productLeftToRight = new int[nums.length];
        int[] productRightToLeft = new int[nums.length];

        productLeftToRight[0] = nums[0];
        productRightToLeft[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            productLeftToRight[i] = productLeftToRight[i - 1] * nums[i];
            productRightToLeft[nums.length - i - 1] = productRightToLeft[nums.length - i] * nums[nums.length - i - 1];
        }

        int[] result = new int[nums.length];

        result[0] = productRightToLeft[1];
        result[result.length - 1] = productLeftToRight[result.length - 2];


        for (int i = 1; i < result.length - 1; i++) {
            result[i] = productLeftToRight[i - 1] * productRightToLeft[i + 1];
        }
        return result;
    }

}
