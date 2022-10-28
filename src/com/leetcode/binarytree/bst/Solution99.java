package com.leetcode.binarytree.bst;

import com.leetcode.TreeNode;
import com.leetcode.util.TraversalUtil;

import java.util.List;

/**
 * 恢复二叉搜索树
 */
public class Solution99 {
    public static void main(String[] args) {
//        TreeNode left = new TreeNode(1);
//        TreeNode right = new TreeNode(4, new TreeNode(2), null);
//        TreeNode root = new TreeNode(3, left, right);
//        TreeNode root = new TreeNode(4,new TreeNode(1), new TreeNode(2,new TreeNode(3), null));
        TreeNode root = new TreeNode(3,new TreeNode(1), new TreeNode(4,new TreeNode(2), null));
        //中序遍历
        List<Integer> integers = TraversalUtil.inorderTraversal(root);
        System.out.println(integers);
        Solution solution = new Solution();
        solution.recoverTree(root);
        //中序遍历
        List<Integer> integers1 = TraversalUtil.inorderTraversal(root);
        System.out.println(integers1);
    }

    static class Solution {

        //乱序的两个节点
        TreeNode first = null, second = null;
        //辅助值，相当于一个指针，指向当前遍历的节点
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);

        public void recoverTree(TreeNode root) {

            inorderTraverse(root);
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }

        //中序遍历正常是从小到大排序的
        void inorderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraverse(root.left);
            if (root.val < prev.val) {
                if (first == null) {
                    first = prev;
                }
                second = root;
            }
            prev = root;
            inorderTraverse(root.right);
        }
    }
}
