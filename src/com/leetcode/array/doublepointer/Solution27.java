package com.leetcode.array.doublepointer;

/**
 * 27.移除元素
 */
public class Solution27 {

    public static void main(String[] args) {
        int nums[] = {1,2,2,3,4};
        int i = removeElement(nums, 2);
        System.out.println("长度：" + i);
        for(int j=0;j<i;j++) {
            System.out.println(nums[j]);
        }
    }

    public static int removeElement(int[] nums, int val) {
        int first = 0, second = 0;
        while (second < nums.length) {
            if(nums[second] != val) {
                nums[first] = nums[second];
                first ++;
            }
            second ++;
        }
        return first;
    }
}
