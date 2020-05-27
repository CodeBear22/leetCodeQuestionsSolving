package com.kunal.leetcode;

/**
 * 227. Basic Calculator II
 * <p>
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * <p>
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 * <p>
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 * <p>
 * Input: " 3+5 / 2 "
 * Output: 5
 * Note:
 * <p>
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class BasicCalculatorII {
    public int calculate(String s) {

        int result = 0;
        int num = 0;
        int tail = 0;
        char operator = '+';
        char[] expression = s.toCharArray();

        for (int i = 0; i < expression.length; i++) {

            if (expression[i] == ' ')
                continue;

            if (Character.isDigit(expression[i])) {
                num = expression[i] - '0';
                i++;
                while (Character.isDigit(i)) {
                    num = num * 10 + (expression[i] - '0');
                    i++;
                }

                switch (operator) {
                    case '+': {
                        result += tail;
                        tail = num;
                    }
                    break;

                    case '-': {
                        result += tail;
                        tail = -num;
                    }
                    break;

                    case '*': {
                        result *= tail;
                    }
                    break;

                    case '/': {
                        result /= tail;
                    }
                    break;
                }
            } else {
                operator = expression[i];
            }
        }
        return result + tail;
    }
}
