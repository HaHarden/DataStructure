package com.leetcode.binarytree.bst;

import com.leetcode.TreeNode;

/**
 * 235.二叉搜索树的最近公共祖先
 */
public class Solution235 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,new TreeNode(1,new TreeNode(0), null),new TreeNode(3));
        Solution s = new Solution();
        System.out.println(s.lowestCommonAncestor(root, new TreeNode(0),new TreeNode(3)).val);
    }

    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null)
                return null;
            //p 和 q在root的左右子树上，那么root就是最近公共祖先
            if(root.val >= Math.min(p.val, q.val) && root.val <= Math.max(p.val, q.val)) {
                return root;
            }
            //p和q都在root的左子树上，那么就去左子树上找他们的公共祖先
            else if(root.val > Math.max(p.val, q.val)) {
                return lowestCommonAncestor(root.left, p, q);
            }
            //p和q都在root的右子树上，那么就去右子树上找他们的公共祖先
            else {
                return lowestCommonAncestor(root.right, p, q);
            }
        }
    }
}
