package com.leetcode.array.doublepointer;

/**
 * 167.两数之和 II -输入有序数组
 */
public class Solution167 {
    public static void main(String[] args) {
        int[] numbers = {-1,0};
        int[] ints = twoSum(numbers, -1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0, right = numbers.length-1;
        while (left != right) {
            int add = numbers[left] + numbers[right];
            if(add > target) {
                right --;
                continue;
            }
            else if(add < target) {
                left ++;
                continue;
            }
            else {
                res[0] = ++left;
                res[1] = ++right;
                break;
            }
        }
        return res;
    }
}
