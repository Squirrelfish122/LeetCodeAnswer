package com.hyman.zhh.leetcode;

import java.util.Arrays;

/**
 * Created by hyman.zhh at 2020/06.
 * https://leetcode-cn.com/problems/3sum-closest/
 * <p>
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Solution16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int answer = nums[0] + nums[1] + nums[2];
        for (int i = 0; i <= nums.length - 3; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (Math.abs(sum - target) < Math.abs(answer - target)) {
                    answer = sum;
                }

                if (sum < target) {
                    start++;
                } else if (sum > target) {
                    end--;
                } else {
                    // sum = target
                    return sum;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Solution16 solution = new Solution16();
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
