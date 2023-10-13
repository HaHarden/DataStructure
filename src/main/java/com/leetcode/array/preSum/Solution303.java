package com.leetcode.array.preSum;

/**
 * 303.区域和检索-数组不可变
 *
 * 前缀和 问题
 */
public class Solution303 {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray2 obj = new NumArray2(nums);
        int left=0, right=2;
        int param_1 = obj.sumRange(left,right);
        System.out.println(param_1);
    }

    static class NumArray {
        int[] nums;
        public NumArray(int[] nums) {
            this.nums = nums;
        }
        //不用前缀和
        public int sumRange(int left, int right) {
            int sum = 0;
            for(int i=left; i<=right; i++) {
                sum += nums[i];
            }
            return sum;
        }
    }

    //前缀和 解决，不在 sumRange 方法中做循环
    static class NumArray2 {
        //preNums中存储 preNums[i] = nums[0...i-1]之和
        int[] preSums;
        public NumArray2(int[] nums) {
            //前缀和 数组 preNums[i] = nums[0] + ... + nums[i-1]
            //前缀和 数组 preNums[i] 存放 nums 数组的 前 i-1 个元素之和
            preSums = new int[nums.length+1];
            for(int i=1; i<preSums.length; i++) {
                preSums[i] = preSums[i-1] + nums[i-1];
            }
        }

        public int sumRange(int left, int right) {
            return preSums[right+1] - preSums[left];
        }
    }

}
