package com.hyman.zhh.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class Solution48 {

    public void rotate(int[][] matrix) {
        Queue<Integer> queue = new LinkedList<>();
        int n = matrix[0].length;
        // 需要执行的圈数, [0, n/2)
        for (int q = 0; q < n / 2; q++) {
            int x = q, y = q;
            // 需要交换的两点的间隔
            int interval = getInterval(n, q);
            int index = interval;
            while (index > 0) {
                queue.offer(matrix[x][y]);
                int[] nextPoint = getNextPoint(n, q, x, y);
                x = nextPoint[0];
                y = nextPoint[1];
                index--;
            }
            int count = interval * 4;
            index = 1;
            while (index <= count) {
                if (index <= count - interval) {
                    // need add
                    queue.offer(matrix[x][y]);
                }
                matrix[x][y] = queue.poll();
                int[] nextPoint = getNextPoint(n, q, x, y);
                x = nextPoint[0];
                y = nextPoint[1];
                index++;
            }
        }
    }

    private int getInterval(int n, int q) {
        return n - 2 * q - 1;
    }

    private int[] getNextPoint(int n, int q, int x, int y) {
        int[] point = new int[2];
        if (x == q && y < n - 1 - q) {
            // x不变，y+1
            point[0] = x;
            point[1] = y + 1;
        } else if (y == n - 1 - q && x < n - 1 - q) {
            // x+1, y不变
            point[0] = x + 1;
            point[1] = y;
        } else if (x == n - 1 - q && y > q) {
            // x不变, y-1
            point[0] = x;
            point[1] = y - 1;
        } else {
            // x-1, y不变
            point[0] = x - 1;
            point[1] = y;
        }
        return point;
    }
}
