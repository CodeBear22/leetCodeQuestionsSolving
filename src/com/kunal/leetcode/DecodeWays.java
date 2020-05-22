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

    public int numDecodingsDynamic(String s) {
        if(s.length() == 0)
            return 0;
        if(s.charAt(0) == '0')
            return 0;
        int[] dp = new int[s.length() + 1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= s.length(); i++)
        {
            int single = Integer.parseInt(s.substring(i - 1, i));
            int pair = Integer.parseInt(s.substring(i-2, i));
            
            if(single >= 1 && single <= 9)
                dp[i] += dp[i-1];


            if(pair >= 10 && pair <= 26)
                dp[i] += dp[i-1];
        }

        return dp[dp.length - 1];

    }
}
