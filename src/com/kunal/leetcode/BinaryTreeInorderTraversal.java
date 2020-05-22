package com.kunal.leetcode;

import com.kunal.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
    /**
     * 94. Binary Tree Inorder Traversal
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        Stack<TreeNode> tempStack = new Stack<>();
        TreeNode current = root;

        while (current != null || !tempStack.isEmpty())
        {
            while(current != null)
            {
                tempStack.push(current);
                current = current.left;
            }

            current = tempStack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
}
