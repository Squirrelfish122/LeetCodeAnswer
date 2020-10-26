package com.hyman.zhh.leetcode.weekly;

import java.util.*;

/**
 * Created by hyman.zhh at 2020/05
 */
public class Solution5414 {

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        HashMap<Integer, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<String> item = favoriteCompanies.get(i);
            int size = item.size();
            if (map.containsKey(size)) {
                map.get(size).add(i);
            } else {
                ArrayList<Integer> indexs = new ArrayList<>();
                indexs.add(i);
                map.put(size, indexs);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<String> item = favoriteCompanies.get(i);
            int size = item.size();
            boolean find = false;
            exit:
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                Integer count = entry.getKey();
                if (size >= count) {
                    continue;
                }
                List<Integer> indexs = entry.getValue();
                for (int index: indexs) {
                    List<String> list = favoriteCompanies.get(index);
                    if (list.containsAll(item)) {
                        find = true;
                        break exit;
                    }
                }
            }
            if (!find) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution5414 solution = new Solution5414();
//        System.out.println(solution.peopleIndexes());
    }
}
