package com.kunal.leetcode;

import com.kunal.utils.ListNode;

//2. Add Two Numbers
//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
public class AddTwoNumbers {
    /**
     * leetCode 2
     *
     * @param l1 com.kunal.utils.ListNode list
     * @param l2 com.kunal.utils.ListNode list
     * @return com.kunal.utils.ListNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        int sum;
        ListNode result = null;
        ListNode result2 = null;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            if (result == null) {
                result = new ListNode(sum);
                result2 = result;
            } else {
                result.next = new ListNode(sum);
                result = result.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = l1.val + carry;
            sum = sum % 10;
            carry = sum / 10;

            if (result == null) {
                result = new ListNode(sum);
                result2 = result;
            } else {
                result.next = new ListNode(sum);
                result = result.next;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = l2.val + carry;
            sum = sum % 10;
            carry = sum / 10;

            if (result == null) {
                result = new ListNode(sum);
                result2 = result;
            } else {
                result.next = new ListNode(sum);
                result = result.next;
            }
            l2 = l2.next;
        }

        if (carry > 0) {
            result.next = new ListNode(carry);
        }
        return result2;
    }
}
