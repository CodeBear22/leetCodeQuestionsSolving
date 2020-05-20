package com.kunal.leetcode;

import com.kunal.utils.ListNode;

//19. Remove Nth Node From End of List
//Given a linked list, remove the n-th node from the end of list and return its head.
//
//Example:
//
//Given linked list: 1->2->3->4->5, and n = 2.
//
//After removing the second node from the end, the linked list becomes 1->2->3->5.
//Note:
//
//Given n will always be valid.
public class RemoveNthNodeFromEndOfList {
    /**
     * leetCode 19
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast, slow;
        fast = head;
        slow = head;

        int index = 0;
        while (fast != null) {
            fast = fast.next;
            if (index >= n + 1) {
                slow = slow.next;
            }
            index++;
        }
        if (index == n) {
            head = head.next;
            return head;
        }

        slow.next = slow.next.next;
        return head;
    }
}
