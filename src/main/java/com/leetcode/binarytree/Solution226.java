package com.leetcode.binarytree;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

//226.翻转二叉树
public class Solution226 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Solution solution = new Solution();
        System.out.println("翻转前，前序遍历");
        System.out.println(solution.preTraversal(root));
        TreeNode treeNode = solution.invertTree(root);
        System.out.println("翻转后，前序遍历");
        System.out.println(solution.preTraversal(treeNode));
    }

    /**
     * 只需要交换每一个子树的左右节点即可完成整棵二叉树的翻转
     */
    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root == null) {
                return null;
            }
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = root.left;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }

        //前序遍历
        public List<Integer> preTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            if(root == null) {
                return res;
            }
            res.add(root.val);
            res.addAll(preTraversal(root.left));
            res.addAll(preTraversal(root.right));
            return res;
        }
    }
}
