package com.hyman.zhh.leetcode;

import java.util.Arrays;

/**
 * Created by hyman.zhh at 2020/06.
 * https://leetcode-cn.com/problems/daily-temperatures/
 * 739. 每日温度
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class Solution739 {

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        int maxIndex = T.length - 1;
        int max = T[maxIndex];
        result[maxIndex] = 0;
        for (int i = maxIndex - 1; i >= 0; i--) {
            if (T[i] >= max) {
                result[i] = 0;
                maxIndex = i;
                max = T[i];
            } else {
                result[i] = findLargerStep(T[i], T, i + 1, maxIndex);
            }
        }
        return result;
    }

    public int findLargerStep(int target, int[] nums, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            count++;
            if (nums[i] > target) {
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution739 solution = new Solution739();
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
