package com.hyman.zhh.leetcode.tree;

/**
 * Created by hyman.zhh at 2020/07.
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class Solution108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        int count = end - start + 1;
        if (count <= 0) {
            return null;
        } else if (count == 1) {
            return new TreeNode(nums[start]);
        } else if (count == 2) {
            TreeNode node = new TreeNode(nums[end]);
            node.left = new TreeNode(nums[start]);
            return node;
        } else if (count == 3) {
            // 3个元素
            TreeNode node = new TreeNode(nums[start + 1]);
            node.left = new TreeNode(nums[start]);
            node.right = new TreeNode(nums[end]);
            return node;
        }
        int middle = (end + start) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = buildTree(nums, start, middle - 1);
        node.right = buildTree(nums, middle + 1, end);
        return node;
    }

}
