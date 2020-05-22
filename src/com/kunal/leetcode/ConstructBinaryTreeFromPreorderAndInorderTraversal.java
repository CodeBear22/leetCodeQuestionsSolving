package com.kunal.leetcode;

import com.kunal.utils.TreeNode;

import java.util.HashMap;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        TreeNode root = new TreeNode(11);

        HashMap<Integer, Integer> preorderMap = new HashMap<>();
        for(int i = 0; i < preorder.length; i++)
        {
            preorderMap.put(preorder[i], i);
        }
        return _buildTreeHelper(preorderMap, 0, inorder.length - 1, inorder);
    }

    public TreeNode _buildTreeHelper(HashMap<Integer, Integer> preorder, int leftIndex, int rightIndex, int[] inorder) {

        if(leftIndex > rightIndex)
            return null;


        int preorderIndex = Integer.MAX_VALUE;
        int rootVal = 0;
        int inorderIndex = -1;


        for(int i = leftIndex; i <= rightIndex; i++)
        {
            if(preorder.containsKey(inorder[i]) && preorder.get(inorder[i]) < preorderIndex) {
                preorderIndex = preorder.get(inorder[i]);
                rootVal = inorder[i];
                inorderIndex = i;
            }
        }

        TreeNode root = new TreeNode(rootVal);

        root.left = _buildTreeHelper(preorder,leftIndex, inorderIndex - 1, inorder);
        root.right = _buildTreeHelper(preorder,inorderIndex + 1, rightIndex, inorder);

        return root;
    }
}
