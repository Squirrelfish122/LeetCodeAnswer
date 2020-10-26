package com.hyman.zhh.leetcode.weekly;

/**
 * Created by hyman.zhh at 2020/05
 */
public class Solution5412 {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] start = {9,8,7,6,5,4,3,2,1};
        int[] end = {10,10,10,10,10,10,10,10,10};

        Solution5412 solution = new Solution5412();
        System.out.println(solution.busyStudent(start, end, 5));
    }
}
