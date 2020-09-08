package com.hyman.zhh.leetcode.tree;

/**
 * Created by hyman.zhh at 2020/09.
 * 222. 完全二叉树的节点个数
 * 给出一个完全二叉树，求出该树的节点个数。
 * <p>
 * 说明：
 * <p>
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * 输出: 6
 */
public class Solution222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int d = getDepth(root);
        if (d == 1) {
            return 1;
        }
        int left = 1, end = (int) Math.pow(2, d - 1), right = end;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (exists(root, d, middle)) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left - 1 + end - 1;
    }

    /**
     * 判断最后一层是否包含index的结点
     *
     * @param node
     * @param depth
     * @param index
     * @return
     */
    private boolean exists(TreeNode node, int depth, int index) {
        int left = 1, right = (int) Math.pow(2, depth - 1);
        for (int i = 0; i < depth - 1; i++) {
            int middle = (left + right) / 2;
            if (index <= middle) {
                node = node.left;
                right = middle;
            } else {
                node = node.right;
                left = middle + 1;
            }
        }
        return node != null;
    }

    private int getDepth(TreeNode root) {
        TreeNode node = root;
        int depth = 1;
        while ((node = node.left) != null) {
            depth++;
        }
        return depth;
    }
}
