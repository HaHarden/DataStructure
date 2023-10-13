package com.leetcode.experience.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 496.下一个更大元素I
 */
public class Solution496 {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 2, 4};
        int[] nums2 = {6, 5, 4, 3, 2, 1, 7};
        Solution s = new Solution();
        int[] ints = s.nextGreaterElement2(nums1, nums2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    static class Solution {
        //最笨的循环套循环
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] res = new int[nums1.length];
            int cur = 0;
            for (int i = 0; i < nums1.length; i++) {
                int add = -1;
                cur = nums1[i];
                for (int j = 0; j < nums2.length; j++) {
                    //从nums2中找到nums1的元素
                    if (nums2[j] == cur) {
                        //从j后开始找比cur大的元素
                        for (int k = j + 1; k < nums2.length; k++) {
                            if (nums2[k] > cur) {
                                add = nums2[k];
                                break;
                            }
                        }
                    }
                }
                res[i] = add;
            }
            return res;
        }

        //用单调栈加哈希表
        //逆序遍历nums2，用单调栈维护下一个更大元素，while栈顶元素比当前元素小时，就出栈，所以栈顶元素就是下一个更大值，栈为空时，返回-1
        public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
            //哈希表，用于存放每一个元素及他下一个更大值的map表
            Map<Integer, Integer> map = new HashMap<>();
            //单调栈
            Deque<Integer> stack = new ArrayDeque<>();
            //找出nums2中每一个元素的下一个更大值
            for(int i=nums2.length-1; i>=0; i--) {
                while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                    stack.pop();
                }
                map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
                stack.push(nums2[i]);
            }
            int[] res = new int[nums1.length];
            for(int i=0; i<nums1.length; i++) {
                res[i] = map.get(nums1[i]);
            }
            return res;
        }
    }
}
