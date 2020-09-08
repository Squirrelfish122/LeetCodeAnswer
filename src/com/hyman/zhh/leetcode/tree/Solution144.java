package com.hyman.zhh.leetcode.tree;

import com.hyman.zhh.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hyman.zhh at 2020/08.
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 */
public class Solution144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        return preorder(root);
    }

    private List<Integer> preorder(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        list.add(node.val);
        if (node.left != null) {
            list.addAll(preorder(node.left));
        }

        if (node.right != null) {
            list.addAll(preorder(node.right));
        }
        return list;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }
}
