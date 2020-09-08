package com.hyman.zhh.leetcode.tree;

import com.hyman.zhh.leetcode.tree.Node;

/**
 * Created by hyman.zhh at 2020/08.
 * <p>
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数小于 6000
 * -100 <= node.val <= 100
 */
public class Solution117 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node leftmost = root;
        while (leftmost != null) {
            Node current = leftmost;
            while (current != null) {
                if (current.left != null) {
                    current.left.next = findNext(true, current);
                }
                if (current.right != null) {
                    current.right.next = findNext(false, current);
                }
                current = current.next;
            }
            leftmost = findNextLevelFirst(leftmost);
        }
        return root;
    }

    private Node findNext(boolean isLeft, Node parent) {
        if (isLeft && parent.right != null) {
            return parent.right;
        }
        Node cur = parent.next;
        while (cur != null) {
            if (cur.left != null) {
                return cur.left;
            }
            if (cur.right != null) {
                return cur.right;
            }
            cur = cur.next;
        }
        return null;
    }

    private Node findNextLevelFirst(Node leftmost) {
        Node cur = leftmost;
        while (cur != null) {
            if (cur.left != null) {
                return cur.left;
            }
            if (cur.right != null) {
                return cur.right;
            }
            cur = cur.next;
        }
        return null;
    }
}
