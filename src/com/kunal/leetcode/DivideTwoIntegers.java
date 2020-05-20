package com.kunal.leetcode;

//29. Divide Two Integers
public class DivideTwoIntegers {

    /**
     * leetCode 29
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        int result = 0;

        if (divisor == 1) return dividend;

        if (divisor == -1) return (dividend == Integer.MIN_VALUE) ? Integer.MAX_VALUE : -dividend;

        if (divisor == 0) return Integer.MAX_VALUE;

        if (dividend == 0) return 0;

        boolean negative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

        long divis = Math.abs((long) divisor);
        long divid = Math.abs((long) dividend);

        result = _divideHelper(divis, divid);
        return negative ? -result : result;
    }

    private int _divideHelper(long divisor, long dividend) {
        if (divisor > dividend)
            return 0;

        int result = 1;
        long sum = divisor;

        while ((sum + sum) <= dividend) {
            sum += sum;
            result += result;
        }
        return result + _divideHelper(divisor, dividend - sum);
    }
}
