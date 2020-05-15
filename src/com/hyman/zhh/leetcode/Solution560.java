package com.hyman.zhh.leetcode;

import java.util.HashMap;

/**
 * Created by hyman.zhh at 2020/05.
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * <p>
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class Solution560 {

    /**
     * 方法一：枚举
     * <p>
     * 遍历整个数组，检查以当前元素作为第一个数据的子数组是否满足要求。
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(n^2)，其中 n 为数组的长度。遍历整个数组需要O(n)的时间，检查每个元素的子数组需要O(n-i)，其中i为当前元素的下标，总共需要 O(n^2)的时间，其中求和需要 O(1)的时间复杂度，因此总时间复杂度为 O(n^2)。
     * <p>
     * 空间复杂度：O(1)。只需要常数空间存放若干变量。
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int result = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 方法二：前缀和 + 哈希表优化
     * <p>
     * 我们定义 pre[i] 为 [0..i] 里所有数的和，则 pre[i] 可以由 pre[i−1] 递推而来，即：
     * pre[i]=pre[i−1]+nums[i]
     * <p>
     * 那么[j..i] 这个子数组和为 k这个条件我们可以转化为
     * pre[i]−pre[j−1]==k
     * <p>
     * 简单移项可得符合条件的下标 j 需要满足
     * pre[j−1]==pre[i]−k
     * <p>
     * 所以我们考虑以 i 结尾的和为 k 的连续子数组个数时只要统计有多少个前缀和为 pre[i]−k 的个数即可。我们建立哈希表mp，以和为键，出现次数为对应的值，记录 pre[i] 出现的次数，从左往右边更新 mp 边计算答案，那么以 i 结尾的答案 mp[pre[i]−k] 即可在 O(1) 时间内得到。最后的答案即为所有下标结尾的和为 k 的子数组个数之和。
     * <p>
     * 需要注意的是，从左往右边更新边计算的时候已经保证了mp[pre[i]−k] 里记录的 pre[j] 的下标范围是 0≤j≤i。同时，由于pre[i] 的计算只与前一项的答案有关，因此我们可以不用建立 pre 数组，直接用 pre 变量来记录 pre[i−1] 的答案即可。
     * <p>
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(n)，其中 n 为数组的长度。我们遍历数组的时间复杂度为 O(n)，中间利用哈希表查询删除的复杂度均为 O(1)，因此总时间复杂度为 O(n)。
     * <p>
     * 空间复杂度：O(n)，其中 n 为数组的长度。哈希表在最坏情况下可能有 n 个不同的键值，因此需要 O(n) 的空间复杂度。
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int temp = sum - k;
            if (hashMap.containsKey(temp)) {
                count += hashMap.get(temp);
            }
            hashMap.merge(sum, 1, Integer::sum);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution560 solution = new Solution560();

        System.out.println(solution.subarraySum2(new int[]{1, 1, 1}, 2));

    }
}
