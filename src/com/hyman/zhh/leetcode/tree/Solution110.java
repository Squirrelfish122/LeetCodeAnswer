package com.hyman.zhh.leetcode.tree;

import com.hyman.zhh.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hyman.zhh at 2020/07.
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 */
public class Solution110 {

    private Map<TreeNode, Integer> heightMap = new HashMap<>();

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (heightMap.containsKey(node)) {
            return heightMap.get(node);
        }
        int height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        heightMap.put(node, height);
        return height;
    }
}
