package com.leetcode.binarytree;

import com.leetcode.TreeNode;

public class Solution236 {
    public static void main(String[] args) {

    }
    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null)
                return null;
            //如果根节点先遍历到了p或q，那么直接返回根节点
            if(root == p || root == q) {
                return root;
            }
            //如果p和q不是根节点，那么从左子树中找
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            //从右子树中找
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            //如果在左右子树中都可以找到p或q，那么他们的LCA就是root
            if(left != null && right != null) {
                return root;
            }
            //如果左右子树中都找不到p和q，那么返回null
            if(left == null && right == null) {
                return null;
            }
            //如果能找到p或q中的一个，那么返回找到的那个节点
            return left == null ? right : left;
        }
    }
}
