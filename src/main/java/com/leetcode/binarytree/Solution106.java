package com.leetcode.binarytree;


import com.leetcode.TreeNode;

/**
 * 106.从中序与后序遍历序列构造二叉树
 */
public class Solution106 {
    public static void main(String[] args) {
        int[] inorder = {1,2,3};
        int[] postorder = {1,3,2};
        Solution s = new Solution();
        TreeNode treeNode = s.buildTree(inorder, postorder);
        System.out.println(treeNode.val);
        System.out.println(treeNode.left.val);
        System.out.println(treeNode.right.val);
    }

    static class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        }

        TreeNode build(int[] inorder, int inStart, int inEnd,
                       int[] postorder, int postStart, int postEnd) {
            if(inStart > inEnd || postStart > postEnd) {
                return null;
            }
            int rootVal = postorder[postEnd];
            TreeNode root = new TreeNode(rootVal);
            int index = -1;
            for (int i=inStart; i<=inEnd; i++) {
                if(inorder[i] == rootVal) {
                    index = i;
                    break;
                }
            }
            int rightSize = inEnd - index;
            root.left = build(inorder, inStart, index-1, postorder, postStart, postEnd-rightSize-1);
            root.right = build(inorder, index+1, inEnd, postorder, postEnd-rightSize, postEnd-1);
            return root;
        }
    }
}




