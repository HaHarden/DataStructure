package com.leetcode.experience.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 503.下一个更大元素II
 * 环形数组， nums[nums.length-1] 的下一个元素是 nums[0]
 *
 * 重点：假设数组长度翻倍，然后无需构造新数组，利用 % 运算进行循环遍历    单调栈的都是逆序遍历
 */
public class Solution503 {
    public static void main(String[] args) {
        int[] nums = {1,4,3,2};
        Solution s = new Solution();
        int[] ints = s.nextGreaterElements(nums);
        for (int anInt : ints) {
            System.out.printf("%d\t", anInt);
        }
        System.out.println();
        int[] nums2 = {1,2,3,4,3};
        int[] ints1 = s.nextGreaterElements(nums2);
        for (int i : ints1) {
            System.out.printf("%d\t", i);
        }

    }

    static class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int[] res = new int[nums.length];
            Deque<Integer> stack = new ArrayDeque<>();
            //假设数组长度翻倍
            int length = nums.length;
            for(int i = 2* length -1; i>=0; i--) {
                while (!stack.isEmpty() && stack.peek() <= nums[i % length]) {
                    stack.pop();
                }
                res[i % length] = stack.isEmpty() ? -1 :stack.peek();
                stack.push(nums[i % length]);
            }
            return res;
        }
    }
}
