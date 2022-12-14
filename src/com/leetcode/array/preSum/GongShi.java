package com.leetcode.array.preSum;

/**
 * 前缀和公式
 * 前缀和主要适用的场景是原始数组不会被修改的情况下，频繁查询某个区间的累加和。
 */
public class GongShi {
    class PrefixSum {
        // 前缀和数组
        private int[] prefix;

        /* 输入一个数组，构造前缀和 */
        public PrefixSum(int[] nums) {
            prefix = new int[nums.length + 1];
            // 计算 nums 的累加和
            for (int i = 1; i < prefix.length; i++) {
                prefix[i] = prefix[i - 1] + nums[i - 1];
            }
        }

        /* 查询闭区间 [i, j] 的累加和 */
        public int query(int i, int j) {
            return prefix[j + 1] - prefix[i];
        }
    }
}
