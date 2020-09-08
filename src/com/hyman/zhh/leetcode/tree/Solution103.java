package com.hyman.zhh.leetcode.tree;

import com.hyman.zhh.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hyman.zhh at 2020/06.
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class Solution103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        LinkedList<TreeNode> oneStack = new LinkedList<>();
        LinkedList<TreeNode> anotherStack = new LinkedList<>();
        oneStack.push(root);
        boolean fromLeft2Right = true;
        while (!oneStack.isEmpty() || !anotherStack.isEmpty()) {
            ArrayList<Integer> floor = new ArrayList<>();
            if (fromLeft2Right) {
                while (!oneStack.isEmpty()) {
                    TreeNode node = oneStack.pop();
                    floor.add(node.val);
                    if (node.left != null) {
                        anotherStack.push(node.left);
                    }
                    if (node.right != null) {
                        anotherStack.push(node.right);
                    }
                }
            } else {
                while (!anotherStack.isEmpty()) {
                    TreeNode node = anotherStack.pop();
                    floor.add(node.val);
                    if (node.right != null) {
                        oneStack.push(node.right);
                    }
                    if (node.left != null) {
                        oneStack.push(node.left);
                    }
                }
            }
            fromLeft2Right = !fromLeft2Right;
            lists.add(floor);
        }
        return lists;
    }
}
