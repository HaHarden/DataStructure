package com.leetcode.binarytree;

import com.leetcode.TreeNode;

/**
 * 100.相同的树
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1：
 *
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * 示例 3：
 *
 *
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 *
 * 提示：
 *
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 */
public class Solution100 {
    public static void main(String[] args) {

        TreeNode p = new TreeNode(1, new TreeNode(2), null);
        TreeNode q = new TreeNode(1, new TreeNode(2), null);
        Solution solution = new Solution();
        System.out.println(solution.isSameTree(p,q));
    }

    /**
     *1.先比较根节点:
     *  如果根节点都为null，直接返回true
     *  如果根节点有一个为null，直接返回false
     *  如果根节点都不为null，且值不相等，也直接返回false
     *2.如果根节点值相等：
     *  再递归比较其左右子树
     *  对于左右子树，也是相同的道理，先比较其根节点，根节点相等再递归其左右子树
     */
    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            //根节点都为null，直接返回true
            if(p == null && q == null) {
                return true;
            }
            //根节点有一个为null，那么不需要进行递归子树，直接返回false即可
            if(p == null || q == null) {
                return false;
            }
            //如果根节点的值相同才需要进行下一步递归，根节点的值不同直接返回false就行，不需要递归
            if(p.val != q.val) {
                return false;
            }
            //程序执行到这一步，当前根节点的值相同，需要进行比较其左右子树
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
