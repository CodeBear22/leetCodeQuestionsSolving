package com.kunal.leetcode;

import com.kunal.utils.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Stack<TreeNode> ltr = new Stack<>();
        Stack<TreeNode> rtl = new Stack<>();

        ltr.push(root);

        while (!ltr.isEmpty() || !rtl.isEmpty()) {

            int levelWidth = ltr.size();
            List<Integer> list = new ArrayList<>();
            TreeNode current;

            while (levelWidth > 0) {
                current = ltr.pop();
                if (current != null && current.left != null) rtl.push(current.left);
                if (current != null && current.right != null) rtl.push(current.right);
                levelWidth--;
                list.add(current.val);
            }

            levelWidth = rtl.size();

            if(list.size() > 0)
                result.add(list);

            list = new ArrayList<>();

            while (levelWidth > 0) {
                current = rtl.pop();
                if (current != null && current.right != null) ltr.push(current.right);
                if (current != null && current.left != null) ltr.push(current.left);
                levelWidth--;
                list.add(current.val);
            }

            if(list.size() > 0)
                result.add(list);
        }
        return result;
    }
}
