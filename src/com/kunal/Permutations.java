package com.kunal;


//46. Permutations

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of distinct integers, return all possible permutations.
//
//Example:
//
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
public class Permutations {
    /**
     * leetCode 46
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] tempCombination = new int[nums.length];
        boolean[] usedIndexes = new boolean[nums.length];
        Arrays.fill(usedIndexes, false);
        _permuteHelper(nums, result, tempCombination, usedIndexes, 0);
        return result;
    }

    private void _permuteHelper(int[] input, List<List<Integer>> result, int[] tempCombination, boolean[] usedIndexes, int currentIndex) {
        if (currentIndex == input.length) {
            List<Integer> combination = new ArrayList<>();
            for (int item : tempCombination)
                combination.add(item);
            result.add(combination);
        } else {

            for (int i = 0; i < usedIndexes.length; i++) {
                if (!usedIndexes[i]) {
                    tempCombination[currentIndex] = input[i];
                    usedIndexes[i] = true;
                    _permuteHelper(input, result, tempCombination, usedIndexes, currentIndex + 1);
                    usedIndexes[i] = false;
                }
            }
        }
    }
}
