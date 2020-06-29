package com.hyman.zhh.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hyman.zhh at 2020/06.
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * <p>
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 */
public class Solution101 {

    public boolean isSymmetric3(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }


    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val && check(node1.left, node2.right) && check(node1.right, node2.left);
    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        do {
            nodes = getNextFloorNodes(nodes);
            if (isLastFloor(nodes)) {
                return true;
            }
            if (!isValidFloor(nodes)) {
                return false;
            }
        } while (true);
    }

    private List<TreeNode> getNextFloorNodes(List<TreeNode> nodes) {
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node == null) {
                treeNodes.add(null);
                treeNodes.add(null);
            } else {
                treeNodes.add(node.left);
                treeNodes.add(node.right);
            }
        }
        return treeNodes;
    }

    private boolean isLastFloor(List<TreeNode> nodes) {
        for (TreeNode node : nodes) {
            if (node != null) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidFloor(List<TreeNode> nodes) {
        int size = nodes.size();
        for (int i = 0; i < size / 2; i++) {
            TreeNode start = nodes.get(i);
            TreeNode end = nodes.get(size - 1 - i);

            boolean valid = (start == null && end == null) ||
                    (start != null && end != null && start.val == end.val);
            if (!valid) {
                return false;
            }
        }
        return true;
    }
}
