package com.leetcode.binarytree;

import com.leetcode.TreeNode;

/**
 * 222.完全二叉树的节点数
 */
public class Solution222 {

    public static void main(String[] args) {
        //完全二叉树  complete binary Tree
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        Solution s = new Solution();
        System.out.println(s.countNodes(root));
    }


    static class Solution {
        public int countNodes(TreeNode root) {
            if(root == null)
                return 0;
            //左右子树起点
            TreeNode l = root, r = root;
            //左右子树高度
            int hl = 0, hr = 0;
            while(l != null) {
                l = l.left;
                hl ++;
            }
            while(r != null) {
                r = r.right;
                hr ++;
            }
            //左右子树高度相同。按照满二叉树计算
            if(hl == hr) {
                return (int) Math.pow(2, hl) - 1;
            }
            //左右子树高度不同，是完全二叉树，按照普通二叉树计算
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
