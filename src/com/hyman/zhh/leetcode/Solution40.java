package com.hyman.zhh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例1:
 *
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例2:
 *
 * 输入: candidates =[2,5,2,1,2], target =5,
 * 所求解集为:
 * [
 *  [1,2,2],
 *  [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum2(candidates, candidates.length - 1, target);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int end, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        // find end
        while (end >= 0 && candidates[end] > target) {
            end--;
        }
        if (end < 0) {
            return lists;
        }
        // find start
        int start = 0;
        int sum = candidates[start];
        while (start < end && sum < target) {
            sum += candidates[++start];
        }
        int lastValue = 0;
        for (int i = end; i >= start; i--) {
            int current = candidates[i];
            if (current == lastValue) {
                continue;
            }
            int offset = target - current;
            if (offset == 0) {
                lastValue = current;
                lists.add(Arrays.asList(current));
            } else {
                List<List<Integer>> subList = combinationSum2(candidates, i - 1, offset);
                if (subList.size() > 0) {
                    lastValue = current;
                    for (List<Integer> item : subList) {
                        List<Integer> integers = new ArrayList<>(item);
                        integers.add(current);
                        lists.add(integers);
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Solution40().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        long interval = System.currentTimeMillis() - start;
        System.out.println("interval = " + interval);

    }

}
