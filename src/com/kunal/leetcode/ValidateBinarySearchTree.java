package com.kunal.leetcode;

import com.kunal.utils.TreeNode;

/**
 * 98. Validate Binary Search Tree
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 * <p>
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * <p>
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return _isValidateBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean _isValidateBSTHelper(TreeNode root, long minValue, long maxValue) {
        if (root == null)
            return true;

        if (root.val <= minValue || root.val >= maxValue)
            return false;

        return _isValidateBSTHelper(root.left, minValue, root.val) && _isValidateBSTHelper(root.right, root.val, maxValue);
    }
}
