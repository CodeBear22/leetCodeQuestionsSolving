package com.kunal.leetcode;

//8. String to Integer (atoi)
public class StringToIntegerAtoi {

    /**
     * leetCode 8
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {

        int start;
        long result;

        start = 0;
        result = 0;
        str = str.trim();
//        String.tri
        while (start < str.length() && str.charAt(start) == ' ') start++;

        if (start >= str.length()) return 0;

        boolean negative = false;

        if (str.charAt(start) == '-') {
            negative = true;
            start++;
        } else if (str.charAt(start) == '+') {
//            negative = false;
            start++;
        } else if (!Character.isDigit(str.charAt(start))) {
            return 0;
        }

        while (start < str.length()) {
            if (!Character.isDigit(str.charAt(start)))
                break;
            if (negative) {
                result = result * 10 - (str.charAt(start) - '0');
                if (result <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            } else {
                result = result * 10 + (str.charAt(start) - '0');
                if (result >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }
            start++;
        }
        return (int) result;
    }
}
