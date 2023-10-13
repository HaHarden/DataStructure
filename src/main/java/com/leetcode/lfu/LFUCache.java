package com.leetcode.lfu;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class LFUCache {

    int capacity,time;
    Map<Integer, Node> map = new HashMap<>();
    //用平衡二叉树的性质维护两个变量的比较关系：先比较使用次数，少的放左节点，使用次数相同再比较使用时间，使用时间小的（久未使用）放左节点
    TreeSet<Node> cacheTree = new TreeSet<>();


    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.time = 0;
    }

    public int get(int key) {
        if(this.capacity <= 0) {
            return -1;
        }
        if(!map.containsKey(key)) {
            return -1;
        }
        //get操作需要更新对应的缓存，即更新key对应缓存的使用次数cnt，使用时间time，然后重新设置缓存，然后返回value
        Node cache = map.get(key);
        cacheTree.remove(cache);
        cache.cnt += 1;
        cache.time = ++time;
        cacheTree.add(cache);
        map.put(key, cache);
        return cache.value;
    }

    public void put(int key, int value) {
        if(this.capacity <= 0) {
            return;
        }
        //put的时候先看有没有key，有的话就不用考虑满不满
        if(!map.containsKey(key)) {
            //如果满了，就需要删除最少使用的key（cnt最小的），如果有多个，需要删除最久未使用的key（time最小的）
            if(map.size() == capacity) {
                map.remove(cacheTree.first().key);
                cacheTree.remove(cacheTree.first());
            }
            Node cache = new Node(1, ++time, key, value);
            map.put(key, cache);
            cacheTree.add(cache);
        }
        else {
            Node cache = map.get(key);
            cacheTree.remove(cache);
            cache.cnt += 1;
            cache.time += 1;
            cache.value = value;
            map.put(key, cache);
            cacheTree.add(cache);
        }
    }

    //缓存类
    class Node implements Comparable<Node> {
        //使用次数
        int cnt;
        //时间戳
        int time;
        int key;
        int value;

        public Node(int cnt, int time, int key, int value) {
            this.cnt = cnt;
            this.time = time;
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            //使用次数相同，就比较使用时间
            return this.cnt == o.cnt ? this.time-o.time : this.cnt-o.cnt;
        }
    }

    public static void main(String[] args) {
        Solution460.LFUCache obj = new Solution460.LFUCache(1);
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
