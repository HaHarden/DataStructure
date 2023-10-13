package com.leetcode.array.doublepointer;

/**
 * 344.反转字符串
 */
public class Solution344 {
    public static void main(String[] args) {
        char[] s = {'h','e','l'};
        reverseString(s);
        for (char s2 : s) {
            System.out.println(s2);
        }
    }

    public static void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        while (left < right) {
            char tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;
            left ++;
            right --;
        }
    }
}
