package com.kunal.leetcode;

import com.kunal.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * <p>
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * <p>
 * <p>
 * Note:
 * <p>
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 */
public class LowestCommonAncestorOfBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pToRootPath = new ArrayList<>();
        List<TreeNode> qToRootPath = new ArrayList<>();
        List<TreeNode> currentPath = new ArrayList<>();

        currentPath.add(root);
        _preOrderTraverseRecursive(root, p, pToRootPath, currentPath, false);
        currentPath.clear();
        currentPath.add(root);
        _preOrderTraverseRecursive(root, q, qToRootPath, currentPath, false);

        int shorterPath = Math.min(pToRootPath.size(), qToRootPath.size());

        for (int i = 0; i < shorterPath; i++) {
            if (pToRootPath.get(i) != qToRootPath.get(i))
                return pToRootPath.get(i - 1);
        }
        return null;
    }

    private boolean _preOrderTraverseRecursive(TreeNode root, TreeNode searchNode, List<TreeNode> pathToNode, List<TreeNode> currentPath, boolean found) {


        if (root == null)
            return false;


        if (searchNode == root) {
            currentPath.add(root);

            pathToNode.addAll(currentPath);
            return true;
        }

        boolean result;

        currentPath.add(root.left);
        result = _preOrderTraverseRecursive(root.left, searchNode, pathToNode, currentPath, found);
        currentPath.remove(currentPath.size() - 1);

        if (!result) {
            currentPath.add(root.right);
            result = _preOrderTraverseRecursive(root.right, searchNode, pathToNode, currentPath, found);
            currentPath.remove(currentPath.size() - 1);
        }
        return result;
    }
}
