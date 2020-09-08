package com.hyman.zhh.leetcode.tree;

import com.hyman.zhh.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hyman.zhh at 2020/07.
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class Solution106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length <= 0
                || postorder == null || inorder.length != postorder.length) {
            return null;
        }

        int length = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, length - 1, 0, length - 1, map);

    }

    private TreeNode build(int[] inorder, int[] postorder,
                           int inStart, int inEnd,
                           int postStart, int postEnd,
                           Map<Integer, Integer> map) {
        int rootValue = postorder[postEnd];
        TreeNode node = new TreeNode(rootValue);

        Integer rootIndex = map.get(rootValue);
        int leftCount = rootIndex - inStart;
        if (leftCount > 0) {
            node.left = build(inorder, postorder, inStart, rootIndex - 1,
                    postStart, postStart + leftCount - 1, map);
        }

        int rightCount = inEnd - rootIndex;
        if (rightCount > 0) {
            node.right = build(inorder, postorder, rootIndex + 1, inEnd,
                    postStart + leftCount, postEnd - 1, map);
        }
        return node;
    }

}
