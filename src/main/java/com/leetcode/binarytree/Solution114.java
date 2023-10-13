package com.leetcode.binarytree;

import com.leetcode.TreeNode;

/**
 * 114.二叉树展开为链表
 */
public class Solution114 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Solution s = new Solution();
        s.flatten2(root);
        System.out.println(root.right.val);
        System.out.println(root.right.right.val);
    }

    static class Solution {
        //flatten函数是用来拉平root节点的左右子树的
        //在相信这个函数定义的前提下去写代码，这个函数最终的实现就会变成最初定义的功能
        public void flatten(TreeNode root) {
            if(root == null) {
                return;
            }

            //1.对左右子树递归调用flatten函数，分别拉平左子树和右子树
            flatten(root.left);
            flatten(root.right);

            //此时左右子树已经被拉平，记录一下当前的已经被拉平的左右子树，因为后续要将拉平的左子树赋值给root.right，再将右子树接在左子树上
            TreeNode left = root.left;
            TreeNode right = root.right;

            //2.将左子树赋值给root的右子树
            root.left = null;
            root.right = left;

            //3.将拉平的右子树接在新的右子树（拉平的左子树）上
            TreeNode p = root;
            while (p.right != null) {
                p = p.right;
            }
            p.right = right;
        }

        //重复一遍
        public void flatten2(TreeNode root) {
            if(root == null)
                return;
            //拉平左右子树
            flatten2(root.left);
            flatten2(root.right);
            //记录拉平的左右子树，后续赋值用
            TreeNode left = root.left;
            TreeNode right = root.right;
            //将拉平的左子树赋值给root.right，root.left赋值为null
            root.right = left;
            root.left = null;
            //将拉平的右子树接到现在的右子树上
            //用while循环从根节点一个一个找，当找到一个右子树为null的节点p时，退出循环，将右子树赋值给p.right
            TreeNode p = root;
            while (p.right != null) {
                p = p.right;
            }
            //找到p.right==null的节点，将拉平的右子树赋值给他的right
            p.right = right;
        }
    }

}
