package com.hyman.zhh.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hyman.zhh at 2020/06.
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 * 99. 恢复二叉搜索树
 * 二叉搜索树中的两个节点被错误地交换。
 * <p>
 * 请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,null,null,2]
 * <p>
 * 1
 * /
 * 3
 * \
 * 2
 * <p>
 * 输出: [3,1,null,null,2]
 * <p>
 * 3
 * /
 * 1
 * \
 * 2
 * 示例 2:
 * <p>
 * 输入: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 * /
 * 2
 * <p>
 * 输出: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 * /
 * 3
 * 进阶:
 * <p>
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 */
public class Solution99 {

    public void recoverTree3(TreeNode root) {
        TreeNode x = null, y = null, pred = null, predecessor = null;
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    if (pred != null && pred.val > current.val) {
                        y = current;
                        if (x == null) {
                            x = pred;
                        }
                        // else的时候不能直接break,需要遍历完整棵树,将添加的predecessor.right删除
                    }
                    predecessor.right = null;
                    pred = current;
                    current = current.right;
                }
            } else {
                if (pred != null && pred.val > current.val) {
                    y = current;
                    if (x == null) {
                        x = pred;
                    }
                    // else的时候不能直接break,需要遍历完整棵树,将添加的predecessor.right删除
                }
                pred = current;
                current = current.right;
            }
        }
        swapNode(x, y);
    }

    public void recoverTree2(TreeNode root) {
        TreeNode x = null, y = null, pred = null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (pred != null && pred.val > current.val) {
                y = current;
                if (x == null) {
                    x = pred;
                } else {
                    break;
                }
            }
            pred = current;
            current = current.right;
        }
        swapNode(x, y);
    }

    private void swapNode(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

    public void recoverTree(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        inorder(root, integers);
        int[] numbers = findSwapNumbers(integers);
        recover(root, 2, numbers[0], numbers[1]);
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    private int[] findSwapNumbers(List<Integer> list) {
        int x = -1, y = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                y = list.get(i + 1);
                if (x == -1) {
                    x = list.get(i);
                } else {
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    private void recover(TreeNode node, int count, int x, int y) {
        if (node == null) {
            return;
        }
        if (node.val == x || node.val == y) {
            if (node.val == x) {
                node.val = y;
            } else {
                node.val = x;
            }
            if (--count == 0) {
                return;
            }
        }
        recover(node.left, count, x, y);
        recover(node.right, count, x, y);
    }
}
