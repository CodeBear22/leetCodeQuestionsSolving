package com.kunal.leetcode;

/**
 * 395. Longest Substring with At Least K Repeating Characters
 * <p>
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "aaabb", k = 3
 * <p>
 * Output:
 * 3
 * <p>
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 * <p>
 * Input:
 * s = "ababbc", k = 2
 * <p>
 * Output:
 * 5
 * <p>
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        return helper(chars, 0, chars.length, k);
    }

    private int helper(char[] chars, int start, int end, int k) {

        if (end - start < k)
            return 0;

        int[] charCount = new int[26];

        for (int i = start; i < end; i++) {
            int idx = chars[i] - 'a';
            charCount[idx]++;
        }

        for (int j = start; j < end; j++) {
            if (charCount[chars[j] - 'a'] < k && charCount[chars[j] - 'a'] > 0) {
                int left = helper(chars, start, j, k);
                int right = helper(chars, j + 1, end, k);
                return Math.max(right, left);
            }
        }
        return end - start;
    }
}
