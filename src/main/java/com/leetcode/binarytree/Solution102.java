package com.leetcode.binarytree;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 重点：
 * 需要一个队列Queue来维护（存储）当前层的节点
 * 先把传进来的root节点存（offer）进去，然后while Queue不为空的时候，遍历Queue，然后for循环将queue中的节点poll出来，存进一个list中，
 * 然后，将poll出来的左子节点和右子节点存进queue中，本次循环结束，结果是：
 * list中存了当前层的节点值，queue中存了下一层的节点
 */

/**
 * 102. 二叉树的层序遍历
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例 1：
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 *
 */
public class Solution102 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2), new TreeNode(3,new TreeNode(4), null));
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrder(root);
        System.out.println(lists);
        System.out.println(solution.levelOrder2(root));
    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if(root == null) {
                return res;
            }
            //用来存放当前层层的节点
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                //用来存放每一层的节点值
                List<Integer> level = new LinkedList<>();
                for(int i=0; i<size; i++) {
                    TreeNode poll = q.poll();
                    level.add(poll.val);
                    if(poll.left != null) {
                        q.offer(poll.left);
                    }
                    if(poll.right != null) {
                        q.offer(poll.right);
                    }
                }
                res.add(level);
            }
            return res;
        }

        //重复自己写了一遍
        public List<List<Integer>> levelOrder2(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if(root == null) {
                return res;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                List<Integer> level = new LinkedList<>();
                int size = q.size();
                for(int i=0; i<size; i++) {
                    TreeNode cur = q.poll();
                    level.add(cur.val);
                    if(cur.left != null)
                        q.offer(cur.left);
                    if(cur.right != null)
                        q.offer(cur.right);
                }
                res.add(level);
            }
            return res;

        }
    }

}
