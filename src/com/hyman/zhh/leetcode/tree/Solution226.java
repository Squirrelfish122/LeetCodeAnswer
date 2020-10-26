package com.hyman.zhh.leetcode.tree;

/**
 * Created by hyman.zhh at 2020/09.
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class Solution226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = root.right;
        root.right = root.left;
        root.left = node;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
