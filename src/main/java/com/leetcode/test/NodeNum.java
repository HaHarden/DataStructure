package com.leetcode.test;

import com.leetcode.TreeNode;

public class NodeNum {
    public static void main(String[] args) {
        //英文中的Full Binary Tree  是指一个树的节点要么有两个子节点，要么没有子节点
        //普通二叉树 binary Tree
        TreeNode root = new TreeNode(1,new TreeNode(2),new TreeNode(3,null, new TreeNode(4)));
        //满二叉树 perfect binary Tree
        TreeNode root2 = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        //完全二叉树  complete binary Tree
        TreeNode root3 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        System.out.println("普通二叉树节点数：");
        System.out.println(num(root));
        System.out.println("满二叉树节点数：");
        System.out.println(num2(root2));
        System.out.println("完全二叉树节点数：");
        System.out.println(num3(root3));

    }

    //求普通二叉树的节点数   时间复杂度：O(N)
    public static int num (TreeNode root) {
        if(root == null)
            return  0;
        return 1 + num(root.left) + num(root.right);
    }
    //满二叉树：树的每一层的节点都是满的
    //满二叉树节点数  时间复杂度：O(logN)
    public static int num2(TreeNode root) {
        if(root == null)
            return 0;
        int h = 0;
        while (root != null) {
            root = root.left;
            h ++;
        }
        //满二叉树的节点数是： 2^h-1
        return (int) Math.pow(2, h) - 1;
    }
    //完全二叉树：树的每一层都是紧凑靠左排列的  时间复杂度O(logN*logN)
    public static int num3(TreeNode root) {
        if(root == null)
            return 0;
        //左右子树
        TreeNode l = root, r = root;
        //左右子树的高度
        int hl=0, hr=0;
        while (l != null) {
            l = l.left;
            hl ++;
        }
        while (r != null){
            r = r.right;
            hr ++;
        }
        //左右子树高度相同，是满二叉树
        if(hl == hr) {
            return (int) Math.pow(2, hl) - 1;
        }
        //左右子树高度不相同，是完全二叉树，需要按照普通二叉树的逻辑计算
        return 1 + num3(root.left) + num3(root.right);
    }
}
