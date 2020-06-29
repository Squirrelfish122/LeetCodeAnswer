package com.hyman.zhh.leetcode;

import java.util.*;

/**
 * Created by hyman.zhh at 2020/06.
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class Solution98 {

    public boolean isValidBST2(TreeNode root) {
        return root == null || isValidNode(root, null, null);
    }

    private boolean isValidNode(TreeNode node, Integer lower, Integer upper) {
        if (lower != null && node.val <= lower) {
            return false;
        }

        if (upper != null && node.val >= upper) {
            return false;
        }

        if (node.left != null && !isValidNode(node.left, lower, node.val)) {
            return false;
        }

        if (node.right != null && !isValidNode(node.right, node.val, upper)) {
            return false;
        }
        return true;
    }


    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Set<Integer>> childMap = new HashMap<>();
        queue.offer(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            if (!isValidNode(node, childMap)) {
                return false;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return true;
    }

    private boolean isValidNode(TreeNode node, Map<TreeNode, Set<Integer>> childMap) {
        if (node.left != null) {
            Set<Integer> leftNodes = getAllNode(node.left, childMap);
            for (Integer item : leftNodes) {
                if (item >= node.val) {
                    return false;
                }
            }
        }
        if (node.right != null) {
            Set<Integer> rightNodes = getAllNode(node.right, childMap);
            for (Integer item : rightNodes) {
                if (item <= node.val) {
                    return false;
                }
            }
        }
        return true;
    }

    private Set<Integer> getAllNode(TreeNode node, Map<TreeNode, Set<Integer>> childMap) {
        Set<Integer> set = childMap.get(node);
        if (set != null) {
            return set;
        }

        set = new HashSet<>();
        set.add(node.val);
        if (node.left != null) {
            set.addAll(getAllNode(node.left, childMap));
        }

        if (node.right != null) {
            set.addAll(getAllNode(node.right, childMap));
        }
        childMap.put(node, set);
        return set;
    }


}
