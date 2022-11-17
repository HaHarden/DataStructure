package com.leetcode.array.doublepointer;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 26.删除有序数组中的重复项
 */
public class Solution26 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4};
        int[] nums2 = {1};
        int i = removeDuplicates(nums2);
        System.out.println("长度：" + i);
        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);
        }

        int i1 = removeDuplicates2(nums);
        System.out.println("长度：" + i1);
        for(int j=0; j<i1; j++) {
            System.out.println(nums[j]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
//                i++;
            }
            j++;
        }
        return i + 1;
    }

    public static int removeDuplicates2(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int i=0;
        for (Integer num : set) {
            nums[i] = num;
            i++;
        }
        return set.size();
    }
}
