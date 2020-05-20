package com.kunal.leetcode;

//22. Generate Parentheses

import java.util.ArrayList;
import java.util.List;

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//For example, given n = 3, a solution set is:
//
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
public class GenerateParentheses {
    /**
     * leetCode 22
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] tempCombination = new char[n * 2];
        _generateParenthesisHelper(result, tempCombination, 0, n, n);

        return result;
    }

    private void _generateParenthesisHelper(List<String> result, char[] tempCombination, int currentIndex, int closeBracketsLeft, int openBracketsLeft) {

        if (currentIndex == tempCombination.length) {
            result.add(new String(tempCombination));
        }

        if (openBracketsLeft > 0) {
            tempCombination[currentIndex] = '(';
            _generateParenthesisHelper(result, tempCombination, currentIndex + 1, closeBracketsLeft, openBracketsLeft - 1);
        }

        if (closeBracketsLeft > 0 && closeBracketsLeft > openBracketsLeft) {
            tempCombination[currentIndex] = ')';
            _generateParenthesisHelper(result, tempCombination, currentIndex + 1, closeBracketsLeft - 1, openBracketsLeft);
        }
    }
}
