package com.leetcode.array.doublepointer;

/**
 * 5.最长回文字串
 */
public class Solution5 {
    public static void main(String[] args) {
        String s = "babad";
        String s2 = "cbbd";
        String s3 = "a";
        String s4 = "ac";
//        System.out.println(s.substring(0,2));
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }

    public static String longestPalindrome(String s) {
        String res = "";
        for(int i=0; i<s.length(); i++) {
            //回文串长度为奇数
            // 以 s[i] 为中心的最长回文子串
            String s1 = findPalindrome(s, i, i);
            //回文串长度为偶数
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = findPalindrome(s, i, i+1);
            //找到s1与s2中的最长的串
            res = res.length()>s1.length() ? res : s1;
            res = res.length()>s2.length() ? res : s2;
        }
        return res;
    }

    //找到以left和right开头，分别向两边移动的最长回文串（两个指针从中间向两边移动）
    public static String findPalindrome(String s, int left, int right) {
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
