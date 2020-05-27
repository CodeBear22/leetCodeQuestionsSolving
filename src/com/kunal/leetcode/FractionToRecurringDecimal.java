package com.kunal.leetcode;

import java.util.HashMap;

/**
 * 166. Fraction to Recurring Decimal
 * <p>
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p>
 * Example 1:
 * <p>
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 * <p>
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 * <p>
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 */
public class FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();

        if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) sb.append("-");

        long divisor = Math.abs((long) numerator);
        long dividend = Math.abs((long) denominator);
        sb.append(divisor / dividend);
        long reminder = divisor % dividend;

        if (reminder == 0)
            return sb.toString();
        sb.append(".");

        HashMap<Long, Integer> reminderMap = new HashMap<>();

        while (reminder > 0) {

            if (reminderMap.containsKey(reminder)) {
                sb.insert(reminderMap.get(reminder), "(");
                sb.append(")");
                return sb.toString();
            }
            reminderMap.put(reminder, sb.length());
            reminder = reminder * 10;
            sb.append(reminder / dividend);
            reminder = reminder % dividend;
        }
        return sb.toString();
    }
}
