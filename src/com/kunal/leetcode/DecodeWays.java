package com.kunal.leetcode;

import java.util.HashMap;

/**
 * 91. Decode Ways
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {

    /**
     * leetCode 91
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        return _numDecodings(s, 0, dp);
    }

    private int _numDecodings(String numberString, int currentIndex, HashMap<Integer, Integer> dp) {

        if (currentIndex == numberString.length())
            return 1;

        if (currentIndex > numberString.length())
            return 0;

        if (dp.containsKey(currentIndex)) {
            return dp.get(currentIndex);
        }

        int count = 0;
        int number = Integer.parseInt(String.valueOf(numberString.charAt(currentIndex)));
        if (number <= 26 && number > 0) {
            count += _numDecodings(numberString, currentIndex + 1, dp);
        } else {
            dp.put(currentIndex, count);
            return count;
        }

        if (currentIndex + 1 < numberString.length()) {
            number = Integer.parseInt(numberString.substring(currentIndex, currentIndex + 2));
            if (number <= 26 && number > 0) {
                count += _numDecodings(numberString, currentIndex + 2, dp);
            }
        }
        dp.put(currentIndex, count);
        return count;
    }
}
