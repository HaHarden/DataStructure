package com.leetcode.experience.monotonicqueue;

import java.util.*;

/**
 * 239.滑动窗口最大值
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 */
public class Solution239 {
    static class Solution {
        //超时 me
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] res = new int[nums.length-k+1];
            for(int i=0;i<nums.length-k+1; i++) {
                Set<Integer> set = new HashSet<>();
                for(int j=i; j<i+k; j++) {
                    set.add(nums[j]);
                }
                res[i] = Collections.max(set);
            }
            return res;
        }

        //单调队列
        public int[] maxSlidingWindow2(int[] nums, int k) {
            int[] res = new int[nums.length-k+1];
            for(int i=0; i<nums.length-k; i++) {
                Deque<Integer> deque = new ArrayDeque<>();
                while (deque.size() == k) {
                    deque.poll();
                }
                //add放到尾部，push放到头部
                deque.add(nums[i]);
            }

            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        Solution solution = new Solution();
        int[] ints = solution.maxSlidingWindow(nums, 3);
        for (int anInt : ints) {
            System.out.printf(anInt + ",");
        }

    }

}
