package com.hyman.zhh.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hyman.zhh at 2020/09.
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 */
public class Solution230 {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = inorder(root);
        return list.get(k - 1);
    }

    private List<Integer> inorder(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node.left != null) {
            list.addAll(inorder(node.left));
        }
        list.add(node.val);
        if (node.right != null) {
            list.addAll(inorder(node.right));
        }
        return list;
    }


    public int kthSmallest2(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (true) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (--k == 0) {
                return node.val;
            }
            node = node.right;
        }
    }
}
