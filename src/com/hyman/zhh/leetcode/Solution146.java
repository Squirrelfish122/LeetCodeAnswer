package com.hyman.zhh.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by hyman.zhh at 2020/05.
 * <p>
 * https://leetcode-cn.com/problems/lru-cache/
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * <p>
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */
public class Solution146 {

    static class LRUCache {

        private LinkedList<Integer> linkedList;
        private HashMap<Integer, Integer> hashMap;
        private int capacity;

        public LRUCache(int capacity) {
            linkedList = new LinkedList<>();
            hashMap = new LinkedHashMap<>(capacity);
            this.capacity = capacity;
        }

        public int get(int key) {
            Integer value = hashMap.get(key);
            if (value != null) {
                linkedList.remove((Object) key);
                linkedList.addFirst(key);
                return value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            boolean add = !hashMap.containsKey(key);
            if (linkedList.size() >= capacity) {
                if (add) {
                    Integer removed = linkedList.removeLast();
                    hashMap.remove(removed);
                }
            }
            if (!add) {
                linkedList.remove((Object) key);
            }
            hashMap.put(key, value);
            linkedList.addFirst(key);
        }
    }


    public static void main(String[] args) {


        //["LRUCache",  "put","put","get",      "put","get","put",      "get","get","get"]
        //[[2],     [1,1],[2,2],[1],        [3,3],[2],[4,4],        [1],[3],[4]]

        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);

        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));


    }

}
