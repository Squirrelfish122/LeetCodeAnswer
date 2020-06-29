package com.hyman.zhh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyman.zhh at 2020/06.
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * <p>
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例:
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 */
public class Solution297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        List<TreeNode> nodeList = getSubTree(root);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++) {
            if (i != 0) {
                builder.append(",");
            }
            TreeNode treeNode = nodeList.get(i);
            if (treeNode == null) {
                builder.append("null");
            } else {
                builder.append(treeNode.val);
            }
        }
        return builder.toString();
    }

    // 先序遍历
    private List<TreeNode> getSubTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        if (root.left == null) {
            list.add(null);
        } else {
            list.addAll(getSubTree(root.left));
        }

        if (root.right == null) {
            list.add(null);
        } else {
            list.addAll(getSubTree(root.right));
        }
        return list;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() <= 0) {
            return null;
        }

        String[] split = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        buildSubTree(root, split, 1);
        return root;
    }

    private int buildSubTree(TreeNode root, String[] split, int index) {
        String next = split[index];
        index++;
        if (!"null".equals(next)) {
            root.left = new TreeNode(Integer.parseInt(next));
            index = buildSubTree(root.left, split, index);
        }

        next = split[index];
        index++;
        if (!"null".equals(next)) {
            root.right = new TreeNode(Integer.parseInt(next));
            index = buildSubTree(root.right, split, index);
        }
        return index;
    }

    public static void main(String[] args) {
        Solution297 solution = new Solution297();
    }
}
