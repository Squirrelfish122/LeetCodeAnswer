package com.hyman.zhh.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyman.zhh at 2020/08.
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 * <p>
 * <p>
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */
public class Solution114 {
    public void flatten(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(result, root);
        if (result.size() <= 0) {
            return;
        }

        TreeNode node = new TreeNode(root.val);
        TreeNode current = node;
        for (int i = 1; i < result.size(); i++) {
            current.right = new TreeNode(result.get(i));
            current = current.right;
        }
        root.left = null;
        root.right = node.right;
    }

    private void preorder(List<Integer> list, TreeNode current) {
        if (current == null) {
            return;
        }
        list.add(current.val);
        preorder(list, current.left);
        preorder(list, current.right);
    }

    public static void main(String[] args) {
//        [1,2,5,3,4,null,6]

        TreeNode node2 = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode node5 = new TreeNode(5, null, new TreeNode(6));
        TreeNode root = new TreeNode(1, node2, node5);
        new Solution114().flatten(root);
    }

}
