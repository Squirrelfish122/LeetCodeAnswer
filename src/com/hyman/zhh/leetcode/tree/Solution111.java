package com.hyman.zhh.leetcode.tree;

import com.hyman.zhh.leetcode.tree.TreeNode;

import java.util.LinkedList;

/**
 * Created by hyman.zhh at 2020/07.
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 */
public class Solution111 {


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> oneNodeStack = new LinkedList<>();
        LinkedList<TreeNode> anotherNodeStack = new LinkedList<>();
        oneNodeStack.offer(root);
        boolean isOne = true;
        int depth = 1;
        while (!oneNodeStack.isEmpty() || !anotherNodeStack.isEmpty()) {
            if (isOne) {
                while (!oneNodeStack.isEmpty()) {
                    TreeNode node = oneNodeStack.poll();
                    if (isLeafNode(node)) {
                        return depth;
                    }
                    if (node.left != null) {
                        anotherNodeStack.offer(node.left);
                    }
                    if (node.right != null) {
                        anotherNodeStack.offer(node.right);
                    }
                }
            } else {
                while (!anotherNodeStack.isEmpty()) {
                    TreeNode node = anotherNodeStack.poll();
                    if (isLeafNode(node)) {
                        return depth;
                    }
                    if (node.left != null) {
                        oneNodeStack.offer(node.left);
                    }
                    if (node.right != null) {
                        oneNodeStack.offer(node.right);
                    }
                }
            }
            depth++;
            isOne = !isOne;
        }
        return depth;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
