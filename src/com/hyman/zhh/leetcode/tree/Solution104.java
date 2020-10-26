package com.hyman.zhh.leetcode.tree;

import com.hyman.zhh.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyman.zhh at 2020/06.
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class Solution104 {

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth2(root.left);
        int rightDepth = maxDepth2(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 1;
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        while ((treeNodes = getNextFloorNodes(treeNodes)).size() > 0) {
            count++;
        }
        return count;
    }

    private List<TreeNode> getNextFloorNodes(List<TreeNode> nodes) {
        ArrayList<TreeNode> result = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node.left != null) {
                result.add(node.left);
            }

            if (node.right != null) {
                result.add(node.right);
            }
        }
        return result;
    }
}
