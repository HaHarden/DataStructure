package com.leetcode.array.difference;

/**
 * 370.区间加法
 */
public class Solution370 {
    public static void main(String[] args) {
        int length = 5;
        int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};

        int[] modifiedArray = getModifiedArray(length, updates);
        for (int i : modifiedArray) {
            System.out.println(i);
        }

//        int[] nums = {0,0,0,0,0};
//        Difference difference = new Difference(nums);
//        difference.increment(1,3,2);
//        difference.increment(2,4,3);
//        difference.increment(0,2,-2);
//        int[] result = difference.result();
//        for (int i : result) {
//            System.out.println(i);
//        }
    }

    static int[] getModifiedArray(int length, int[][] updates) {
        // nums 初始化为全 0
        int[] nums = new int[length];
        // 构造差分解法
        Difference df = new Difference(nums);

        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];
            df.increment(i, j, val);
        }

        return df.result();
    }
}

//差分数组工具类
class  Difference {
    //差分数组
    int[] diff;

    public Difference(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for(int i=1; i<diff.length; i++) {
            diff[i] = nums[i] - nums[i-1];
        }
    }

    public void increment(int i, int j, int val) {
        //diff[i] += val，相当于给原数组从i开始，每个值都加val
        diff[i] += val;
        if(j+1 < diff.length) {
            //diff[j+1] -= val 相当于给原数组从j+1开始，每个值都减val
            diff[j+1] -= val;
        }
    }

    public int[] result() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for(int i=1; i<diff.length; i++) {
            res[i] = res[i-1] + diff[i];
        }
        return res;
    }
}

