package com.hyman.zhh.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by hyman.zhh at 2020/06.
 * https://leetcode-cn.com/problems/valid-sudoku/
 * 36. 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * <p>
 * 上图是一个部分填充的有效的数独。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ['5','3','.','.','7','.','.','.','.'],
 * ['6','.','.','1','9','5','.','.','.'],
 * ['.','9','8','.','.','.','.','6','.'],
 * ['8','.','.','.','6','.','.','.','3'],
 * ['4','.','.','8','.','3','.','.','1'],
 * ['7','.','.','.','2','.','.','.','6'],
 * ['.','6','.','.','.','.','2','8','.'],
 * ['.','.','.','4','1','9','.','.','5'],
 * ['.','.','.','.','8','.','.','7','9']
 * ]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * [
 * ['8','3','.','.','7','.','.','.','.'],
 * ['6','.','.','1','9','5','.','.','.'],
 * ['.','9','8','.','.','.','.','6','.'],
 * ['8','.','.','.','6','.','.','.','3'],
 * ['4','.','.','8','.','3','.','.','1'],
 * ['7','.','.','.','2','.','.','.','6'],
 * ['.','6','.','.','.','.','2','8','.'],
 * ['.','.','.','4','1','9','.','.','5'],
 * ['.','.','.','.','8','.','.','7','9']
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 */
public class Solution36 {

    public boolean isValidSudoku(char[][] board) {

        int size = 9;
        List<Character> list = new ArrayList<>();
        // row
        for (int i = 0; i < size; i++) {
            list.clear();
            for (int j = 0; j < size; j++) {
                if (board[i][j] != '.') {
                    list.add(board[i][j]);
                }
            }

            if (!isValidItem(list)) {
                System.out.println("row, index = " + i + ", list = " + list);
                return false;
            }
        }

        // column
        for (int i = 0; i < size; i++) {
            list.clear();
            for (int j = 0; j < size; j++) {
                if (board[j][i] != '.') {
                    list.add(board[j][i]);
                }
            }

            if (!isValidItem(list)) {
                System.out.println("column, index = " + i + ", list = " + list);
                return false;
            }
        }

        // block
        int blockSize = 3;
        for (int k = 0; k < size; k++) {
            list.clear();
            int startI = (k % 3) * blockSize;
            int startJ = (k / 3) * blockSize;
            for (int i = 0; i < blockSize; i++) {
                for (int j = 0; j < blockSize; j++) {
                    if (board[startI + i][startJ + j] != '.') {
                        list.add(board[startI + i][startJ + j]);
                    }
                }
            }
            if (!isValidItem(list)) {
                System.out.println("block, index = " + k + ", list = " + list);
                return false;
            }
        }
        return true;
    }

    public boolean isValidItem(List<Character> list) {
        HashSet<Character> hashSet = new HashSet<>();
        for (Character c : list) {
            if (hashSet.contains(c)) {
                return false;
            } else {
                hashSet.add(c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution36 solution = new Solution36();
        System.out.println(solution.isValidSudoku(new char[][]{
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        }));

        //        System.out.println(solution.isValidSudoku(new char[][]{
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
    }
}
