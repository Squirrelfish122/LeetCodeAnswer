package com.hyman.zhh.leetcode;

/**
 * Created by hyman.zhh at 2020/5.
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/single-number
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class Solution136 {

    /**
     * 答案是使用位运算。对于这道题，可使用异或运算 ^。异或运算有以下三个性质。
     * <p>
     * 任何数和0做异或运算，结果仍然是原来的数，即 a ^ 0= a。
     * 任何数和其自身做异或运算，结果是0，即 a ^ a=0。
     * 异或运算满足交换律和结合律，即 a ^ b ^ a=b ^ a ^ a=b ^ (a ^ a)=b ^ 0=b。
     *
     * @param nums
     */
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution136 solution = new Solution136();
        int[] number = {17, 12, 5, -6, 12, 4, 17, -5, 2, -3, 2, 4, 5, 16, -3, -4, 15, 15, -4, -5, -6};
        // 16
        System.out.println(solution.singleNumber(number));
    }
}
