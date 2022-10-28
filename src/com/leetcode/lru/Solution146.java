package com.leetcode.lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * LRU缓存 （Least Recently Used）
 * 最近使用的最有用
 */
public class Solution146 {

    class LRUCache {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        int cap;

        public LRUCache(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            if(!map.containsKey(key)) {
                return -1;
            }
            //将key变为最近使用的key
            makeRecently(key);
            return map.get(key);
        }

        public void put(int key, int value) {
            if(map.containsKey(key)) {
                //修改key的值
                map.put(key, value);
                //将当前key作为最近使用的key
                makeRecently(key);
                return;
            }
            if(map.size() >= cap) {
                //删除最久未使用的key
                Integer first = map.keySet().iterator().next();
                map.remove(first);
            }
            //插入key
            map.put(key, value);
        }

        public void makeRecently(int key) {
            Integer val = map.get(key);
            map.remove(key);
            map.put(key, val);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
