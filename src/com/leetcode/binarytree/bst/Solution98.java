package com.leetcode.binarytree.bst;

import com.leetcode.TreeNode;

/**
 * 验证二叉搜索树
 */
public class Solution98 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4, new TreeNode(2), null);
        TreeNode root = new TreeNode(3, left, right);
        Solution solution = new Solution();
        System.out.println(solution.isValidBST(root));
    }

    static class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }

        /**
         * 要把当前根节点传递到其左右子树的比较中，不能只比较每个子树的根节点与左右节点的大小关系
         * @param root
         * @param min
         * @param max
         * @return
         */
        public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
            if(root == null)
                return true;
            if(min != null && root.val <= min.val) {
                return false;
            }
            if(max != null && root.val >= max.val) {
                return false;
            }
            return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
        }
    }
}

