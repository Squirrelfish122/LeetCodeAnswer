package com.hyman.zhh.leetcode.tree;

import com.hyman.zhh.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hyman.zhh at 2020/07.
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class Solution107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        LinkedList<List<Integer>> tempStack = new LinkedList<>();
        LinkedList<TreeNode> oneQueue = new LinkedList<>();
        LinkedList<TreeNode> anotherQueue = new LinkedList<>();
        oneQueue.offer(root);
        boolean isOne = true;

        while (!oneQueue.isEmpty() || !anotherQueue.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            if (isOne) {
                while (!oneQueue.isEmpty()) {
                    TreeNode node = oneQueue.poll();
                    item.add(node.val);
                    if (node.left != null) {
                        anotherQueue.offer(node.left);
                    }
                    if (node.right != null) {
                        anotherQueue.offer(node.right);
                    }
                }
            } else {
                while (!anotherQueue.isEmpty()) {
                    TreeNode node = anotherQueue.poll();
                    item.add(node.val);
                    if (node.left != null) {
                        oneQueue.offer(node.left);
                    }
                    if (node.right != null) {
                        oneQueue.offer(node.right);
                    }
                }
            }
            isOne = !isOne;
            tempStack.push(item);
        }
        ArrayList<List<Integer>> lists = new ArrayList<>();
        while (!tempStack.isEmpty()) {
            lists.add(tempStack.pop());
        }
        return lists;
    }
}
