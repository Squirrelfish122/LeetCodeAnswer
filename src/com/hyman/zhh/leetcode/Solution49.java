package com.hyman.zhh.leetcode;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length <= 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> hashMap = new HashMap<>();
        for (String item : strs) {
            char[] chars = item.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, new ArrayList<>());
            }
            hashMap.get(key).add(item);
        }
        return new ArrayList<>(hashMap.values());
    }
}
