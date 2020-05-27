package com.kunal.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * <p>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> combination = new ArrayList<>();
        _partitionHelper(s, 0, combination, result);
        return result;
    }

    private void _partitionHelper(String input, int beginIndex, List<String> combination, List<List<String>> result) {

        if (beginIndex == input.length())
            result.add(new ArrayList<>(combination));
        else {
            for (int i = beginIndex; i < input.length(); i++) {

                if (_isPalindrome(input, beginIndex, i)) {

                    String subset = input.substring(beginIndex, i + 1);
                    combination.add(subset);
                    _partitionHelper(input, i + 1, combination, result);
                    combination.remove(combination.size() - 1);
                }
            }
        }
    }

    private boolean _isPalindrome(String str, int left, int right) {

        while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
