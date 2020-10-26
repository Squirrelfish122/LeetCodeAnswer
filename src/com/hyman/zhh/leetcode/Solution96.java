package com.hyman.zhh.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hyman.zhh at 2020/06.
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class Solution96 {

    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        HashMap<Integer, Integer> numMap = new HashMap<>();
        numMap.put(0, 1);
        numMap.put(1, 1);
        numMap.put(2, 2);
        for (int i = 3; i <= n; i++) {
            calculate(i, numMap);
        }
        return numMap.get(n);
    }

    private void calculate(int n, Map<Integer, Integer> map) {
        // 奇数
        boolean odd = n % 2 != 0;
        int end = (n + 1) / 2;
        int sum = 0;
        for (int i = 1; i <= end; i++) {
            int item = map.get(i - 1) * map.get(n - i);
            if (odd && i == end) {
                // 奇数的最后一项只需要计算一次
                sum += item;
            } else {
                // * 2
                sum += item * 2;
            }
        }
        map.put(n, sum);
    }
}
