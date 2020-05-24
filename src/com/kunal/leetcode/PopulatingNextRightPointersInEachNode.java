package com.kunal.leetcode;

import com.kunal.utils.Node;
import com.kunal.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. Populating Next Right Pointers in Each Node
 * <p>
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * <p>
 * <p>
 * Follow up:
 * <p>
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the given tree is less than 4096.
 * -1000 <= node.val <= 1000
 */
public class PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {

        Queue<Node> temp = new LinkedList<>();

        temp.offer(root);
        Node current;
        int levelWidth;
        Node previous = null;

        while (!temp.isEmpty()) {

            levelWidth = temp.size();

            while (levelWidth > 0) {

                current = temp.poll();
                if (current != null && current.left != null) temp.offer(current.left);
                if (current != null && current.right != null) temp.offer(current.right);

                if (previous != null) {
                    previous.next = current;
                }
                previous = current;
                levelWidth--;
            }
        }
        return root;
    }
}
