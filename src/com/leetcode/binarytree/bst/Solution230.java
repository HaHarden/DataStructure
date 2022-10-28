package com.leetcode.binarytree.bst;


import com.leetcode.TreeNode;

/**
 * 230.二叉树中第k小的元素
 */
public class Solution230 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,new TreeNode(1), new TreeNode(3));
        Solution s = new Solution();
        int i = s.kthSmallest(root, 2);
        System.out.println(i);
    }

    static class Solution {
        //当前遍历到第几个节点
        int rank = 0;
        //结果
        int res = 0;
        //二叉搜索树的中序遍历是从小到大排序的
        public int kthSmallest(TreeNode root, int k) {
            traversal(root, k);
            return res;
        }

        void traversal(TreeNode root, int k) {
            if(root == null) {
                return;
            }
            traversal(root.left, k);
            rank ++;
            if(rank == k) {
                res = root.val;
                return;
            }
            traversal(root.right, k);
        }

    }

}

