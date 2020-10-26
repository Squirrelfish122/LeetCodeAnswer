package com.hyman.zhh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hyman.zhh at 2020/09.
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 */
public class Solution39 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combination(candidates, target, new ArrayList<Integer>(), candidates.length - 1);
        return result;

    }

    /**
     * @param candidates  可以添加的数据
     * @param target      目标值
     * @param currentList 当前列表
     * @param index       当前可以往列表中添加的最后一位的下标（为了消除重复解）
     */
    public void combination(int[] candidates, int target, List<Integer> currentList, int index) {
        if (target < candidates[0]) {
            return;
        }
        for (int i = index; i >= 0; i--) {
            List<Integer> list = new ArrayList<>(currentList);
            int item = candidates[i];
            if (target == item) {
                list.add(item);
                result.add(list);
            } else if (target > item) {
                list.add(item);
                combination(candidates, target - item, list, i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution39().combinationSum(new int[]{2, 3, 5}, 8));
    }
}
