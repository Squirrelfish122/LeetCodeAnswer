package com.hyman.zhh.leetcode;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Solution17 {

    private List<String> result = new ArrayList<>();
    private Map<Character, List<String>> keys = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits != null && digits.length() > 0) {
            addKey('2', "a", "b", "c");
            addKey('3', "d", "e", "f");
            addKey('4', "g", "h", "i");
            addKey('5', "j", "k", "l");
            addKey('6', "m", "n", "o");
            addKey('7', "p", "q", "r", "s");
            addKey('8', "t", "u", "v");
            addKey('9', "w", "x", "y", "z");
            append("", digits);
        }
        return result;
    }

    private void addKey(char key, String... values) {
        List<String> list = new ArrayList<>(Arrays.asList(values));
        keys.put(key, list);
    }

    private void append(String current, String remain) {
        if (remain.length() <= 0) {
            result.add(current);
            return;
        }
        char key = remain.charAt(0);
        remain = remain.substring(1);
        List<String> list = keys.get(key);
        for (String item : list) {
            append(current + item, remain);
        }
    }
}
