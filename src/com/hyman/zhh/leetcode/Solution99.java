package com.hyman.zhh.leetcode;

import java.util.LinkedList;

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

    public void recoverTree(TreeNode root) {

        // TODO: 2020/6/19  

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = root, previous = null;


        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            if (previous == null || previous.val < current.val) {
                previous = current;
            } else {


                return;
            }
            current = current.right;
        }



    }
}
