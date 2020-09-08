package com.hyman.zhh.leetcode.tree;

import com.hyman.zhh.leetcode.tree.TreeNode;

import java.util.LinkedList;

/**
 * Created by hyman.zhh at 2020/07.
 * https://leetcode-cn.com/problems/path-sum/
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class Solution112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        return root != null && hasSum(root, root.val, sum);
    }

    private boolean hasSum(TreeNode root, int currentSum, int sum) {
        if (root.left == null && root.right == null) {
            return currentSum == sum;
        }
        if (root.left != null &&
                hasSum(root.left, currentSum + root.left.val, sum)) {
            return true;
        }
        return root.right != null && hasSum(root.right, currentSum + root.right.val, sum);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum2(root.left, sum) || hasPathSum2(root.right, sum);
    }

    static class Pair {
        public TreeNode node;
        public int remainSum;

        public Pair(TreeNode node, int remainSum) {
            this.node = node;
            this.remainSum = remainSum;
        }
    }

    public boolean hasPathSum3(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        LinkedList<Pair> stack = new LinkedList<>();
        stack.push(new Pair(root, sum - root.val));
        while (!stack.isEmpty()) {
            Pair item = stack.pop();
            TreeNode node = item.node;
            if (node.left == null && node.right == null && item.remainSum == 0) {
                return true;
            }
            if (node.right != null) {
                stack.push(new Pair(node.right, item.remainSum - node.right.val));
            }
            if (node.left != null) {
                stack.push(new Pair(node.left, item.remainSum - node.left.val));
            }
        }
        return false;
    }
}
