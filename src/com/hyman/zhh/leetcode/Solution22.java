package com.hyman.zhh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Solution22 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(new char[n * 2], 0, list);
        return list;
    }

    private void generate(char[] cur, int position, List<String> result) {
        if (position == cur.length) {
            if (valid(cur)) {
                result.add(new String(cur));
            }
        } else {
            cur[position] = '(';
            generate(cur, position + 1, result);
            cur[position] = ')';
            generate(cur, position + 1, result);
        }
    }

    private boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> list, StringBuilder builder, int open, int close, int max) {
        if (builder.length() == max * 2) {
            list.add(builder.toString());
            return;
        }
        if (open < max) {
            builder.append("(");
            backtrack(list, builder, open + 1, close, max);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (close < open) {
            builder.append(")");
            backtrack(list, builder, open, close + 1, max);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
