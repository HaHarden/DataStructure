package com.leetcode.array.doublepointer;

/**
 * 283.移动零
 */
public class Solution283 {
    public static void main(String[] args) {
        int[] nums = {1,2,0,3,0,4};
        int[] nums2 = {0,1,0,3,12};

        moveZeroes(nums2);
        for (int num : nums2) {
            System.out.println(num);
        }
    }

    public static void moveZeroes(int[] nums) {
        int size = removeZero(nums);
        while (size < nums.length) {
            nums[size] = 0;
            size ++;
        }
    }

    public static int removeZero(int[] nums) {
        int first = 0, second = 0;
        while (second < nums.length) {
            if(nums[second] != 0) {
                nums[first] = nums[second];
                first ++;
            }
            second ++;
        }
        return first ++;
    }

    //类似冒泡排序，双层循环，效率低
    public static void moveZeroes2(int[] nums) {
        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] ==0) {
                    int tmp = nums[j];
                    nums[j] = 0;
                    nums[i] = tmp;
                }
            }
        }
    }
}
