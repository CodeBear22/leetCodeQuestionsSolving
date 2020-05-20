package com.kunal.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 */
public class LetterCombinationsOfPhoneNumber {


    /**
     * leetCode 17 prop
     */
    private static final String[] digitToCharactersMapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    /**
     * leetCode 17
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {

        char[] tempCombination = new char[digits.length()];
        List<String> combinations = new ArrayList<>();

        combinationsMakerHelper(digits, 0, tempCombination, combinations);
        return combinations;
    }


    /**
     * leetCode 17 helper
     *
     * @param number
     * @param digit
     * @param tempCombination
     * @param combinations
     */
    private void combinationsMakerHelper(String number, int digit, char[] tempCombination, List<String> combinations) {
        if (digit == number.length()) {
            combinations.add(new String(tempCombination));
        } else {
            for (int i = 0; i < digitToCharactersMapping[number.charAt(digit) - '0'].length(); i++) {
                char c = digitToCharactersMapping[number.charAt(digit) - '0'].charAt(i);
                tempCombination[digit] = c;
                combinationsMakerHelper(number, digit + 1, tempCombination, combinations);
            }
        }
    }
}
