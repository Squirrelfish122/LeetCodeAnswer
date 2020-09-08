package com.hyman.zhh.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hyman.zhh at 2020/06.
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class Solution105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length <= 0 || inorder == null
                || preorder.length != inorder.length) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preorderStart, int preorderEnd,
                           int inorderStart, int inorderEnd, Map<Integer, Integer> map) {
        int rootValue = preorder[preorderStart];
        TreeNode node = new TreeNode(rootValue);
        int rootIndex = map.get(rootValue);
        int leftCount = rootIndex - inorderStart;
        int rightCount = inorderEnd - rootIndex;
        if (leftCount > 0) {
            node.left = build(preorder, inorder, preorderStart + 1, preorderStart + leftCount,
                    inorderStart, rootIndex - 1, map);
        }
        if (rightCount > 0) {
            node.right = build(preorder, inorder, preorderStart + leftCount + 1, preorderEnd,
                    rootIndex + 1, inorderEnd, map);
        }
        return node;
    }

    private int findLeftChildCount(int root, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (root == inorder[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution105 solution = new Solution105();
        solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}
