package com.hyman.zhh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class Solution47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0) {
            return lists;
        }
        if (nums.length == 1) {
            lists.add(Arrays.asList(nums[0]));
            return lists;
        }
        Arrays.sort(nums);
        do {
            lists.add(getList(nums));
        } while ((nums = findNext(nums)) != null);
        return lists;
    }

    private List<Integer> getList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int item : nums) {
            list.add(item);
        }
        return list;
    }

    private int[] findNext(int[] nums) {
        int index = nums.length - 2;
        // >=
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }
        if (index < 0) {
            return null;
        }
        int replaceIndex = index + 1;
        for (int i = index + 2; i < nums.length; i++) {
            // <=
            if (nums[i] > nums[index] && nums[i] <= nums[replaceIndex]) {
                replaceIndex = i;
            }
        }
        swap(nums, index, replaceIndex);
        reverse(nums, index + 1);
        return nums;
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
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
