package com.leetcode.array.doublepointer;

/**
 * 26.删除有序数组中的重复项
 */
public class Solution26 {

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4};
        int[] nums2 = {1};
        int i = removeDuplicates(nums2);
        System.out.println("长度：" + i);
        for(int j=0; j<i; j++) {
            System.out.println(nums[j]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int i=0, j=1;
        while (j < nums.length) {
            if(nums[i] != nums[j]) {
                nums[i+1] = nums[j];
                i++;
            }
            j++;
        }
        return i+1;
    }
}
