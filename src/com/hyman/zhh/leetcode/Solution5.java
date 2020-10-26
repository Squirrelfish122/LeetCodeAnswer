package com.hyman.zhh.leetcode;

/**
 * Created by hyman.zhh at 2020/09.
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Solution5 {
    private int length;
    private String result;

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 0) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            search(s, i, i);
            search(s, i, i + 1);
        }
        return result;
    }

    private void search(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                left++;
                right--;
                break;
            }
        }
        if (left < 0 || right >= s.length()) {
            left++;
            right--;
        }
        int newLength = right - left + 1;
        if (newLength > length) {
            length = newLength;
            result = s.substring(left, right + 1);
        }
    }

}
