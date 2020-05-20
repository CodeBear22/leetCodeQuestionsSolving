package com.kunal.utils;

public class Helper {

    /**
     * Convert int[] to com.kunal.utils.ListNode list
     *
     * @param listValues int[]
     * @return com.kunal.utils.ListNode
     */
    public static ListNode makeArrayToLinkedList(int[] listValues) {
        if (listValues.length == 0) {
            return null;
        }

        ListNode newList = new ListNode(listValues[0]);
        ListNode current = newList;

        for (int i = 1; i < listValues.length; i++) {
            current.next = new ListNode(listValues[i]);
            current = current.next;
        }
        return newList;
    }

    /**
     * To print com.kunal.utils.ListNode
     *
     * @param head com.kunal.utils.ListNode
     */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
            if (head != null)
                System.out.print(" -> ");
        }
        System.out.println();
    }
}
