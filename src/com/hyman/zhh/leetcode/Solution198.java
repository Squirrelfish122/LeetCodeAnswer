package com.hyman.zhh.leetcode;

/**
 * Created by hyman.zhh at 2020/05.
 * https://leetcode-cn.com/problems/house-robber/
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class Solution198 {

    /**
     * 方法一：动态规划 + 滚动数组
     * 首先考虑最简单的情况。如果只有一间房屋，则偷窃该房屋，可以偷窃到最高总金额。如果只有两间房屋，则由于两间房屋相邻，不能同时偷窃，只能偷窃其中的一间房屋，因此选择其中金额较高的房屋进行偷窃，可以偷窃到最高总金额。
     * <p>
     * 如果房屋数量大于两间，应该如何计算能够偷窃到的最高总金额呢？对于第 k (k>2) 间房屋，有两个选项：
     * <p>
     * 偷窃第 k 间房屋，那么就不能偷窃第 k−1 间房屋，偷窃总金额为前 k−2 间房屋的最高总金额与第 k 间房屋的金额之和。
     * <p>
     * 不偷窃第 k 间房屋，偷窃总金额为前 k−1 间房屋的最高总金额。
     * <p>
     * 在两个选项中选择偷窃总金额较大的选项，该选项对应的偷窃总金额即为前 k 间房屋能偷窃到的最高总金额。
     * <p>
     * 用 dp[i] 表示前 i 间房屋能偷窃到的最高总金额，那么就有如下的状态转移方程：
     * <p>
     * dp[i]=max(dp[i−2]+nums[i],dp[i−1])
     * <p>
     * 边界条件为：
     * <p>
     * dp[0]=nums[0]  只有一间房屋，则偷窃该房屋
     * dp[1]=max(nums[0],nums[1])  只有两间房屋，选择其中金额较高的房屋进行偷窃
     * ​
     * 最终的答案即为 dp[n−1]，其中 n 是数组的长度。
     * <p>
     * 上述方法使用了数组存储结果。考虑到每间房屋的最高总金额只和该房屋的前两间房屋的最高总金额相关，因此可以使用滚动数组，在每个时刻只需要存储前两间房屋的最高总金额。
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(n)，其中 n 是数组长度。只需要对数组遍历一次。
     * <p>
     * 空间复杂度：O(1)。使用滚动数组，可以只存储前两间房屋的最高总金额，而不需要存储整个数组的结果，因此空间复杂度是 O(1)。
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int first = nums[0], second = Math.max(nums[0], nums[1]);
        int temp;
        for (int i = 2; i < nums.length; i++) {
            temp = second;
            if (first + nums[i] > second) {
                second = first + nums[i];
            }
            first = temp;
        }
        return Math.max(first, second);
    }

    public static void main(String[] args) {
        Solution198 solution = new Solution198();
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
