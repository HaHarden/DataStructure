package com.leetcode.binarytree.bst;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 19
 */
public class Solution96 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(3));
//        System.out.println(solution.numTrees(5));
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.numTrees(3));
//        System.out.println(solution2.numTrees(5));
    }

    /**
     * 这样不做备忘录会超时
     */
    static class Solution {
        public int numTrees(int n) {
            return count(1, n);
        }

        public int count(int lo, int hi) {
            if (lo > hi) {
                return 1;
            }
            int res = 0;
            //每个都可能为根节点
            //总数 = 左子树数目 * 右子树数目
            for (int i = lo; i <= hi; i++) {
                //左子树都比根节点i小
                int left = count(lo, i - 1);
                //右子树都比根节点i大
                int right = count(i + 1, hi);
                res += left * right;
            }
            return res;
        }
    }

    static class Solution2 {
        //备忘录
        int[][] memo;
        public int numTrees(int n) {
            memo = new int[n+1][n+1];
            return count(1, n);
        }

        public int count(int lo, int hi) {
            if(lo > hi) {
                return 1;
            }
            if(memo[lo][hi] != 0) {
                return memo[lo][hi];
            }
            int res = 0;
            for(int i=lo; i<=hi; i++) {
                int left = count(lo, i-1);
                int right = count(i+1, hi);
                res += left * right;
            }
            memo[lo][hi] = res;
            return res;

        }
    }
}
