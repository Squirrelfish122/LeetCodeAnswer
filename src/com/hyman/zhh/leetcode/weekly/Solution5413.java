package com.hyman.zhh.leetcode.weekly;

import java.util.Arrays;

/**
 * Created by hyman.zhh at 2020/05
 */
public class Solution5413 {

    public String arrangeWords(String text) {
        text = Character.toLowerCase(text.charAt(0)) + text.substring(1);
        String[] split = text.split(" ");
        for (int i = 1; i < split.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (split[j].length() < split[j - 1].length()) {
                    String temp = split[j - 1];
                    split[j - 1] = split[j];
                    split[j] = temp;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (i == 0) {
                String s = split[i];
                s = Character.toUpperCase(s.charAt(0)) + s.substring(1);
                builder.append(s);
            } else {
                builder.append(" ");
                builder.append(split[i]);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {

        Solution5413 solution = new Solution5413();
        System.out.println(solution.arrangeWords("Leetcode is cool"));
        System.out.println(solution.arrangeWords("Keep calm and code on"));
        System.out.println(solution.arrangeWords("To be or not to be"));
    }
}
