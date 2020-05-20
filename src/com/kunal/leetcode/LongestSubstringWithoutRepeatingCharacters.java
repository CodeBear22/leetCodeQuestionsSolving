package com.kunal.leetcode;

import java.util.HashMap;

//3. Longest Substring Without Repeating Characters
//Input: "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * leetCode 3
     *
     * @param s String
     * @return int
     */
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 1 || s.length() == 0) {
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<>();

        int j = 0;
        int maxLength = 0;
        int index;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                maxLength = Math.max(maxLength, i - j + 1);
            } else {
                index = map.get(s.charAt(i));
                j = index >= j ? index + 1 : j;
                map.put(s.charAt(i), i);
                maxLength = Math.max(maxLength, i - j + 1);
            }
        }
        return maxLength;
    }
}
