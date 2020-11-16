package com.hyman.zhh.leetcode;

/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Solution43 {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] numbers1, numbers2;
        if (num1.length() > num2.length()) {
            numbers1 = getNumbers(num1);
            numbers2 = getNumbers(num2);
        } else {
            numbers1 = getNumbers(num2);
            numbers2 = getNumbers(num1);
        }
        // m >= n
        int m = numbers1.length;
        int n = numbers2.length;
        int[][] result = new int[n + 1][m + n + 1];
        for (int i = 0; i < n; i++) {
            // 往高位进的数字
            int extra = 0;
            for (int j = 0; j < m; j++) {
                int temp = numbers1[j] * numbers2[i] + extra;
                extra = temp / 10;
                result[i][i + j] = temp % 10;
            }
            // 乘积多了一位
            if (extra != 0) {
                // i + m
                result[i][i + m] = extra;
            }
        }
        int length = result[0].length;
        int extra = 0;
        for (int i = 0; i < length; i++) {
            int temp = extra;
            for (int j = 0; j < n; j++) {
                temp += result[j][i];
            }
            extra = temp / 10;
            int item = temp % 10;
            result[n][i] = item;
        }
        int[] ints = result[n];
        int end = ints.length - 1;
        while (end >= 0 && ints[end] == 0) {
            end--;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = end; i >= 0; i--) {
            builder.append(ints[i]);
        }
        return builder.toString();
    }

    private int[] getNumbers(String num) {
        char[] chars = num.toCharArray();
        int length = chars.length;
        int[] result = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            result[length - 1 - i] = Integer.parseInt(chars[i] + "");
        }
        return result;
    }

    public String multiply2(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                result[i + j + 1] += x * y;
            }
        }
        for (int i = result.length - 1; i > 0; i--) {
            if (result[i] >= 10) {
                result[i - 1] += result[i] / 10;
                result[i] %= 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        if (result[0] != 0) {
            builder.append(result[0]);
        }
        for (int i = 1; i < result.length; i++) {
            builder.append(result[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution43().multiply("408", "5"));
    }

}
