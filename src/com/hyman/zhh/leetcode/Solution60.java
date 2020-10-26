package com.hyman.zhh.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hyman.zhh at 2020/06.
 * https://leetcode-cn.com/problems/permutation-sequence/
 * 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class Solution60 {

    public String getPermutation(int n, int k) {
        if (n == 0) {
            return "";
        }
        List<String> strings = new ArrayList<>(n);
        Map<Integer, Integer> tempMap = new HashMap<>();
        tempMap.put(0, 1);
        for (int i = 1; i <= n; i++) {
            strings.add("" + i);
            tempMap.put(i, i * tempMap.get(i - 1));
        }

        StringBuilder builder = new StringBuilder();
        while (strings.size() > 0) {
            // (size - 1)!
            int temp = tempMap.get(strings.size() - 1);
            int index = getIndex(strings, k, temp);
            builder.append(strings.remove(index));
            k -= index * temp;
        }
        return builder.toString();
    }

    public int getIndex(List<String> remainChars, int k, int temp) {
        int size = remainChars.size();
        if (size == 1) {
            return 0;
        }

        if (size == 2) {
            // (1, 2)  -> 1,2 or 2,1
            if (k == 1) {
                return 0;
            } else {
                return 1;
            }
        }

        // temp = (size - 1)!
        return (k - 1) / temp;
    }

    public static void main(String[] args) {
        Solution60 solution = new Solution60();
        System.out.println(solution.getPermutation(4, 9));
        System.out.println(solution.getPermutation(3, 3));
    }
}
