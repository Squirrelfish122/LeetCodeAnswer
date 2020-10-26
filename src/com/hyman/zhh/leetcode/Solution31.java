package com.hyman.zhh.leetcode;

/**
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Solution31 {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = -1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                // 找到需要调整的元素
                index = i - 1;
                break;
            }
        }
        if (index == -1) {
            // 数组降序排列，调整为升序
            reverse(nums, 0);
            return;
        }
        // 找到比nums[index]大的最小元素
        int replaceIndex = index + 1;
        for (int i = index + 2; i < nums.length; i++) {
            if (nums[i] > nums[index] && nums[i] <= nums[replaceIndex]) {
                replaceIndex = i;
            }
        }
        // 和nums[index]交换位置
        swap(nums, index, replaceIndex);
        reverse(nums, index + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start; int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
