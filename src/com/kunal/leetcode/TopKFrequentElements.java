package com.kunal.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 347. Top K Frequent Elements
 * <p>
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 * <p>
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 * You can return the answer in any order.
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> valueFrequencyMap = new HashMap<>();

        for (int num : nums) {
            valueFrequencyMap.put(num, valueFrequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (int key : valueFrequencyMap.keySet()) {
            int frequency = valueFrequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] result = new int[k];
        int j = 0;

        for (int i = bucket.length - 1; i >= 0 && j < k; i--) {
            if (bucket[i] != null) {
                for (int l = 0; l < bucket[i].size() && j < k; l++) {
                    result[j++] = bucket[i].get(l);
                }
            }
        }
        return result;
    }
}
