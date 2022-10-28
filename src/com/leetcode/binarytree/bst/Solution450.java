package com.leetcode.binarytree.bst;

import com.leetcode.TreeNode;
import com.leetcode.util.TraversalUtil;

/**
 * 450.删除二叉搜索树中的节点
 */
public class Solution450 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        Solution s = new Solution();
        System.out.println(TraversalUtil.preorderTraversal(root));
        s.deleteNode2(root, 3);
        System.out.println(TraversalUtil.preorderTraversal(root));
    }

    /**
     * 三种情况：
     * 1.如果待删除节点为叶子节点，直接删除
     * 2.如果待删除节点有一个子节点，那么直接让子节点顶替他的位置
     * 3.如果待删除节点有两个子节点，那么需要进行如下操作：
     *  1）找到左子树的最大值或者右子树的最小值顶替他的位置
     *  2）删除左子树的最大值或者右子树的最小值
     */

    static class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            //找到待删除节点
            if (root.val == key) {
                if(root.left == null) {
                    return root.right;
                }
                if(root.right == null) {
                    return root.left;
                }
                //待删除节点有两个子节点，找出右子树的中的最小值顶替待删除节点的值
                TreeNode min = getMin(root);
                root.val = min.val;
                //删除min节点
                root.right = deleteNode(root.right, min.val);
            }
            if (root.val > key) {
                root.left = deleteNode(root.left, key);
            }
            if (root.val < key) {
                root.right =  deleteNode(root.right, key);
            }

            return root;
        }
        TreeNode getMin(TreeNode node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        //自己重复一遍，这次如果待删除节点有两个子节点，那么从左子树中找到最大值顶替待删除节点的值，然后再删除左子树中的最大值
        public TreeNode deleteNode2(TreeNode root, int key) {
            if(root == null) return null;
            //找到待删除节点，进行删除操作，要分情况
            if(root.val == key) {
                //如果待删除节点只有一个子节点，直接返回子节点（此处也包含了没有子节点的情况）
                if(root.left == null) {
                    return root.right;
                }
                if(root.right == null) {
                    return root.left;
                }
                //如果有两个子节点，那么从左子树中找到最大值，替换待删除的节点值，然后将左子树中的最大值删除，然后再将删除节点后的左子树赋值给root.left
                TreeNode max = getMax(root.left);
                root.val = max.val;
                root.left = deleteNode(root.left, max.val);
            }
            //如果当前节点比key大，那么就在其左子树中找到key值进行删除，删除后将左子树赋值给当前root.left
            else if(root.val > key) {
                root.left = deleteNode(root.left, key);
            }
            //如果当前节点比key小，那么就在其右子树中找到key值进行删除，删除后将右子树赋值给当前root.right
            else if(root.val < key) {
                root.right = deleteNode(root.right, key);
            }
            return root;
        }

        TreeNode getMax(TreeNode node) {
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }


    }
}
