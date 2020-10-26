package com.hyman.zhh.leetcode;

/**
 * 29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class Solution29 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                // 只有这种情况会溢出
                return Integer.MAX_VALUE;
            } else {
                return -dividend;
            }
        }
        boolean negative = (dividend ^ divisor) < 0;
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        // temp_value的最大范围[-1, -2^32],即[-2^0, -2^32]
        int[] temp_value = new int[33];
        int[] temp_key = new int[33];
        int length = 0;
        temp_key[length] = 1;
        temp_value[length] = divisor;
        int valueLimit = Integer.MIN_VALUE >> 1;
        while (temp_value[length] >= valueLimit && dividend < temp_value[length]) {
            length++;
            temp_key[length] = temp_key[length - 1] << 1;
            temp_value[length] = temp_value[length - 1] << 1;
        }
        int result = 0;
        while (length >= 0) {
            while (dividend <= temp_value[length]) {
                dividend -= temp_value[length];
                result += temp_key[length];
            }
            length--;
        }
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution29().divide(2147483647, 3));
    }

}
