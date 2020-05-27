package com.kunal.leetcode;

import com.kunal.utils.TreeNode;

import java.util.Stack;

/**
 * 230. Kth Smallest Element in a BST
 * <p>
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * Output: 1
 * Example 2:
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of elements of the BST is between 1 to 10^4.
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> tempSpace = new Stack<>();
        TreeNode current = root;
        while (!tempSpace.isEmpty() || current != null) {

            while (current != null) {
                tempSpace.push(current);
                current = current.left;
            }
            current = tempSpace.pop();
            k--;
            if (k == 0)
                return current.val;

            current = current.right;
        }
        return -1;
    }
}
