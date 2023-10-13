package com.leetcode.binarytree;

import com.leetcode.TreeNode;

/**
 * 105.从前序与中序遍历序列构造二叉树
 */
public class Solution105 {

    public static void main(String[] args) {

    }

    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        }

        TreeNode build(int[] preorder, int preStart, int preEnd,
                       int[] inorder, int inStart, int inEnd) {
            if(preStart > preEnd || inStart > inEnd) {
                return null;
            }
            //前序遍历的第一个数就是根节点
            int rootVal = preorder[preStart];
            TreeNode root = new TreeNode(rootVal);
            int index = -1;
            //在中序遍历结果集中找到根节点的位置index，他左边就是左子树，右边就是右子树
            for(int i=inStart; i<=inEnd; i++) {
                if(inorder[i] == rootVal) {
                    index = i;
                    break;
                }
            }
            int leftSize = index - inStart;
            root.left = build(preorder, preStart+1, preStart+leftSize,inorder, inStart, index-1);
            root.right = build(preorder, preStart+leftSize+1, preEnd, inorder, index+1, inEnd);
            return root;
        }

    }
}
