package com.hyman.zhh.leetcode.tree;

/**
 * Created by hyman.zhh at 2020/06.
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
