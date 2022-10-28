package com.leetcode.binarytree.bst;

import com.leetcode.TreeNode;
import com.leetcode.util.TraversalUtil;

/**
 * 701.二叉树中的插入操作
 */
public class Solution701 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,new TreeNode(1),new TreeNode(3));
        System.out.println(TraversalUtil.preorderTraversal(root));
        Solution s = new Solution();
        s.insertIntoBST(root, 4);
        System.out.println(TraversalUtil.preorderTraversal(root));
    }

    static class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if(root == null) {
                return new TreeNode(val);
            }
            //当前节点比val大，val就插到当前节点的left分支上
            if(root.val > val) {
                root.left = insertIntoBST(root.left, val);
            }
            //当前节点bival小，val就插到当前节点的right分支上
            if(root.val < val) {
                root.right = insertIntoBST(root.right, val);
            }
            return root;
        }
    }
}
