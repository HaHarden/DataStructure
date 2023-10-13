package com.leetcode.lfu;

import java.util.*;

/**
 * LFU缓存 （最不经常使用）
 * 使用频率最高最有用
 */
public class Solution460 {
    static class LFUCache {

        static LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
        int cap;
        //key-使用次数
        static Map<Integer, Integer> map = new HashMap<>();

        public LFUCache(int capacity) {
            cap = capacity;
        }

        public int get(int key) {
            if(cap <= 0) {
                return -1;
            }
            if(!cache.containsKey(key)) {
                return -1;
            }
            //get一次，count+1
//            map.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), key)).map(Map.Entry::getKey).collect(Collectors.toSet());
            //将key变为最近使用的key
            makeRecently(key);
            updateCount(key);
            return cache.get(key);
        }

        public void put(int key, int value) {
            if(cap <= 0) {
                return;
            }

            if(cache.containsKey(key)) {
                cache.put(key, value);
                makeRecently(key);
                updateCount(key);
                return;
            }

            //是否满
            if(cache.size() >= cap) {
                //满了就删除最少使用的key
                Integer leastUsedKey = getLeastUsedKey();
                cache.remove(leastUsedKey);
                map.remove(leastUsedKey);
            }
            cache.put(key, value);
            map.put(key, 1);
        }

        //找到最少使用的key，如果有多个，就取最久未使用的那个key
        public Integer getLeastUsedKey() {
            Integer result = null;
            //最小频率
            Integer minCount = Collections.min(map.values());
            Iterator<Integer> iterator = cache.keySet().iterator();
            //从前往后遍历cache的key，先遇到的就是最久未使用的
            while (iterator.hasNext()) {
                Integer current = iterator.next();
                if(map.get(current).equals(minCount)) {
                    result = current;
                    break;
                }
            }
            return result;
        }

        public void updateCount(int key) {
            Integer value = map.get(key);
            value ++;
            map.remove(key);
            map.put(key, value);
        }

        public void makeRecently(int key) {
            Integer val = cache.get(key);
            cache.remove(key);
            cache.put(key, val);
        }
    }

    /**
     * Your LFUCache object will be instantiated and called as such:
     * LFUCache obj = new LFUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    public static void main(String[] args) {
        LFUCache obj = new LFUCache(1);
        System.out.println("null");
        obj.put(2,1);
        System.out.println("null");
        System.out.println(obj.get(2));
        obj.put(3,2);
        System.out.println("null");
        System.out.println(obj.get(2));
        System.out.println(obj.get(3));
    }
}
