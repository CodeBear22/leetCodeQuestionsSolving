package com.kunal.leetcode;

import com.kunal.utils.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

/**
 * 102. Binary Tree Level Order Traversal
 * <p>
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty())
        {
            int levelLength = q.size();
            List<Integer> list = new ArrayList<>();

            while(levelLength > 0)
            {
                TreeNode current = q.poll();
                if(current != null && current.left != null) q.offer(current.left);
                if(current != null && current.right != null) q.offer(current.right);
                levelLength--;
                list.add(current.val);
            }
            result.add(list);
        }
        return result;
    }

    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        _levelOrderRecursiveHelper(root, 0, result);
        return result;

    }

    private void _levelOrderRecursiveHelper(TreeNode root, int level, List<List<Integer>> result) {

        if(root == null)
            return;

        if(level >= result.size())
        {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);

        _levelOrderRecursiveHelper(root.left, level + 1, result);
        _levelOrderRecursiveHelper(root.right, level + 1, result);
    }
}
