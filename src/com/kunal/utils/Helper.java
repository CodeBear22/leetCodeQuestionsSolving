package com.kunal.utils;

import java.util.Arrays;

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

    /**
     * convert int[] to tree
     */
    public static TreeNode constructTree(Integer[] nodeValues) {
        TreeNode root = new TreeNode(nodeValues[0]);
        new Helper()._constructTreeHelper(0, nodeValues, root);
        return root;
    }

    public void _constructTreeHelper(int currentIndex, Integer[] nodeValues, TreeNode root) {
        if (root == null)
            return;

        if (currentIndex * 2 + 1 < nodeValues.length && nodeValues[currentIndex * 2 + 1] != null) {
            root.left = new TreeNode(nodeValues[currentIndex * 2 + 1]);
            _constructTreeHelper(currentIndex * 2 + 1, nodeValues, root.left);
        }

        if (currentIndex * 2 + 2 < nodeValues.length && nodeValues[currentIndex * 2 + 2] != null) {
            root.right = new TreeNode(nodeValues[currentIndex * 2 + 2]);
            _constructTreeHelper(currentIndex * 2 + 2, nodeValues, root.right);
        }
    }


    public static int stringMismatchCount(String str1, String str2) {

        int mismatchCount = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i))
                mismatchCount++;
        }
        return mismatchCount;
    }

    public static int stringCharacterMismatchCount(String str1, String str2) {
        {
            int missMatchCount = 0;
            int[] alphabetsCount = new int[26];

            Arrays.fill(alphabetsCount, 0);

            for (int i = 0; i < str1.length(); i++) {
                alphabetsCount[str1.charAt(i) - 'a'] += 1;
            }

            for (int i = 0; i < str2.length(); i++) {
                if (alphabetsCount[str2.charAt(i) - 'a'] > 0)
                    alphabetsCount[str2.charAt(i) - 'a']--;
                else
                    missMatchCount++;
            }
            return missMatchCount;
        }

    }
}
