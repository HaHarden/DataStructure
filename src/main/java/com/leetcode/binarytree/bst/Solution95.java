package com.leetcode.binarytree.bst;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 */
public class Solution95 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<TreeNode> trees = solution.generateTrees(3);
        System.out.println(trees.size());
        for (TreeNode tree : trees) {
            //前序遍历
            List<Integer> res = solution.preorderTraversal(tree);
            System.out.println(res);
        }
    }
}

class Solution {
    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    public List<TreeNode> build(int lo, int hi) {
        List<TreeNode> list = new LinkedList<>();
        if(lo > hi) {
            list.add(null);
            return list;
        }
        //1.每个值都可能为根节点，穷举所有可能的根节点
        for(int i=lo; i<=hi; i++) {
            //2.递归构造左右子树的合法BST
            List<TreeNode> leftTree = build(lo, i - 1);
            List<TreeNode> rightTree = build(i + 1, hi);
            //给root节点穷举合法的左右子树
            for (TreeNode leftNode : leftTree) {
                for (TreeNode rightNode : rightTree) {
                    //作为根root的值
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                }
            }
        }
        return list;
    }

    //前序遍历BST
    public List<Integer> preorderTraversal(TreeNode treeNode) {
        List<Integer> list = list(treeNode);
        return list;
    }

    public List<Integer> list(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            res.add(null);
            return res;
        }
        res.add(root.val);
        List<Integer> left = list(root.left);
        res.addAll(left);
        List<Integer> right = list(root.right);
        res.addAll(right);
        return res;
    }
}