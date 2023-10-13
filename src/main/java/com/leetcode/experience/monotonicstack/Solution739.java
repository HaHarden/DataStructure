package com.leetcode.experience.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 739.每日温度
 */
public class Solution739 {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        Solution s = new Solution();
        int[] ints = s.dailyTemperatures(temperatures);
        for (int anInt : ints) {
            System.out.printf("%d\t", anInt);
        }
    }

    static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] answer = new int[temperatures.length];
            //单调栈
            Deque<Integer> stack = new ArrayDeque<>();
            for(int i=temperatures.length-1; i>=0; i--) {
                while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }
                answer[i] = stack.isEmpty() ? 0 : stack.peek() - i;
                stack.push(i);
            }
            return answer;
        }
    }
}
