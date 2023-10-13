package com.leetcode.binarytree.bst;

import com.leetcode.TreeNode;

/**
 * 538.把二叉搜索树转换为累加树
 */
public class Solution538 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,new TreeNode(1), new TreeNode(3));
        Solution s= new Solution();
        TreeNode treeNode = s.convertBST(root);
        System.out.println(treeNode.val);
        System.out.println(treeNode.left.val);
        System.out.println(treeNode.right.val);
    }

    static class Solution {
        int add = 0;
        //从大到小遍历   右中左
        public TreeNode convertBST(TreeNode root) {
            if(root == null) {
                return null;
            }
            convertBST(root.right);
            add += root.val;
            root.val = add;
            convertBST(root.left);
            return root;
        }
    }
}
