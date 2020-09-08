package com.hyman.zhh.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyman.zhh at 2020/07.
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
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
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class Solution113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        path2(root, sum, 0, result, path);
        return result;
    }


    private void path(TreeNode root, int sum, int currentSum, List<List<Integer>> result, List<Integer> path) {
        if (root.left == null && root.right == null) {
            if (currentSum == sum) {
                result.add(path);
            }
            return;
        }

        if (root.left != null) {
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(root.left.val);
            path(root.left, sum, currentSum + root.left.val, result, newPath);
        }

        if (root.right != null) {
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(root.right.val);
            path(root.right, sum, currentSum + root.right.val, result, newPath);
        }
    }


    private void path2(TreeNode root, int sum, int currentSum, List<List<Integer>> result, List<Integer> path) {
        if (root == null) {
            return;
        }
        int nextSum = currentSum + root.val;
        if (root.left == null && root.right == null) {
            if (nextSum == sum) {
                path.add(root.val);
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        if (root.left != null) {
            path(root.left, sum, nextSum, result, path);
        }
        if (root.right != null) {
            path(root.right, sum, nextSum, result, path);
        }
        path.remove(path.size() - 1);
    }

}
