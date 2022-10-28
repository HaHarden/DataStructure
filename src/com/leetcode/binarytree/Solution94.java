package com.leetcode.binarytree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历BST  二叉搜索树
 */
public class Solution94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = null;
        root.left = left1;
        TreeNode right1 = new TreeNode(3);
        TreeNode left2 = new TreeNode(2);
        root.right = right1;
        right1.left  = left2;
        Solution2 solution = new Solution2();
        List<Integer> list = solution.inorderTraversal(root);
        System.out.println(list);
    }

}

class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return new ArrayList<>();
        }
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }

}
