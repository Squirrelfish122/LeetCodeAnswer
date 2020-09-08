package com.hyman.zhh.leetcode.tree;

import com.hyman.zhh.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hyman.zhh at 2020/08.
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 */
public class Solution145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        return postorder(root);
    }

    private List<Integer> postorder(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        list.addAll(postorder(node.left));
        list.addAll(postorder(node.right));
        list.add(node.val);
        return list;
    }

    public List<Integer> postorderTraversal3(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return output;
    }


}
