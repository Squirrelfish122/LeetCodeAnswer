package com.hyman.zhh.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyman.zhh at 2020/06.
 * https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 * 1305. 两棵二叉搜索树中的所有元素
 * 给你 root1 和 root2 这两棵二叉搜索树。
 * <p>
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 */
public class Solution1305 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return getAllChild(root2);
        }

        if (root2 == null) {
            return getAllChild(root1);
        }
        List<Integer> children1 = getAllChild(root1);
        List<Integer> children2 = getAllChild(root2);

        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        int size1 = children1.size();
        int size2 = children2.size();
        while (i < size1 || j < size2) {
            if (i >= size1) {
                result.add(children2.get(j++));
            } else if (j >= size2) {
                result.add(children1.get(i++));
            } else if (children1.get(i) <= children2.get(j)) {
                result.add(children1.get(i++));
            } else {
                result.add(children2.get(j++));
            }
        }
        return result;
    }

    public List<Integer> getAllChild(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> children = new ArrayList<>();
        if (root.left != null) {
            children.addAll(getAllChild(root.left));
        }
        children.add(root.val);
        if (root.right != null) {
            children.addAll(getAllChild(root.right));
        }
        return children;
    }
}
