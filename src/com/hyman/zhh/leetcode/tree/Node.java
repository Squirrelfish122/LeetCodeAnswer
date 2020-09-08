package com.hyman.zhh.leetcode.tree;

/**
 * Created by hyman.zhh at 2020/06.
 */
class Node {

    int val;
    Node left;
    Node right;
    public Node next;

    Node(int x) {
        val = x;
    }

    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
