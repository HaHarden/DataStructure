package com.leetcode.array.difference;

import java.util.Arrays;

/**
 * 1109. 航班预订统计
 */
public class Solution1109 {

    public static void main(String[] args) {
        int[][] bookings = {{1,2,10}, {2,3,20}, {2,5,25}};
        int[][] bookings2 = {{1,2,10}, {2,2,15}};
        int[] res = corpFlightBookings(bookings2, 2);
        Arrays.stream(res).forEach(System.out::println);
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference diff = new Difference(nums);
        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            diff.increment(i, j, val);
        }
        return diff.result();
    }

    //差分数组工具类
    static class Difference {
        int[] diff;
        //构建差分数组
        public Difference(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i=1; i<nums.length; i++) {
                diff[i] = nums[i] - nums[i-1];
            }
        }

        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j+1 < diff.length) {
                diff[j+1] -= val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i=1; i<diff.length; i++) {
                res[i] = res[i-1] + diff[i];
            }
            return res;
        }
    }
}
