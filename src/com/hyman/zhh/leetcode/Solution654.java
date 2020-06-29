package com.hyman.zhh.leetcode;

/**
 * Created by hyman.zhh at 2020/06.
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * <p>
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * <p>
 * <p>
 * <p>
 * 示例 ：
 * <p>
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 * <p>
 * 6
 * /   \
 * 3     5
 * \    /
 * 2  0
 * \
 * 1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定的数组的大小在 [1, 1000] 之间。
 */
public class Solution654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return buildChildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildChildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int maxIndex = getMaxIndex(nums, start, end);
        TreeNode treeNode = new TreeNode(nums[maxIndex]);
        if (start < maxIndex) {
            treeNode.left = buildChildTree(nums, start, maxIndex - 1);
        }
        if (end > maxIndex) {
            treeNode.right = buildChildTree(nums, maxIndex + 1, end);
        }
        return treeNode;
    }


    public int getMaxIndex(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }

        if (start == end) {
            return start;
        }
        int result = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[result]) {
                result = i;
            }
        }
        return result;
    }
}
