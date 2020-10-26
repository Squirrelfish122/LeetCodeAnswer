package com.hyman.zhh.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Solution6 {

    public String convert(String s, int numRows) {
        if (s == null || s.length() <= 0) {
            return "";
        }
        if (numRows <= 1) {
            return s;
        }
        Map<Integer, StringBuilder> map = new HashMap<>();
        for (int i = 0; i < numRows; i++) {
            map.put(i, new StringBuilder());
        }
        // 每2*n-2个字符为一组
        int groupSize = numRows * 2 - 2;
        for (int i = 0; i < s.length(); i++) {
            String item = s.charAt(i) + "";
            int k = i % groupSize;
            if (k < numRows) {
                map.get(k).append(item);
            } else {
                map.get(groupSize - k).append(item);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(map.get(i).toString());
        }
        return result.toString();
    }

    public String convert2(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        List<StringBuilder> builders = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            builders.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            builders.get(curRow).append(c);
            if (curRow == numRows -1 || curRow == 0) {
                goingDown = !goingDown;
            }
            if (goingDown) {
                curRow++;
            } else {
                curRow--;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder builder : builders) {
            result.append(builder);
        }
        return result.toString();
    }
}
