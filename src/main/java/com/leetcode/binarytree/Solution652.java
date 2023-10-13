package com.leetcode.binarytree;

import com.leetcode.TreeNode;

import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 652.寻找重复的子树
 *
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 */
public class Solution652 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(2));
        Solution s = new Solution();
        List<TreeNode> duplicateSubtrees = s.findDuplicateSubtrees(root);
        System.out.println(duplicateSubtrees.size());
        for (TreeNode duplicateSubtree : duplicateSubtrees) {
            System.out.println(duplicateSubtree.val);
        }

    }

    /**
     * 思路：
     * 先记录下来当前节点的样子（即对其进行序列化<后序遍历，先知道其左右子节点长啥样子，就知道他长啥样子>）
     * 将当前节点序列化后的字符串放到一个map<序列化的字符串，个数>中
     * 当遍历下一个节点时，去map中get一下当前节点，如果值为1，就把当前节点放进结果集中
     */

    static class Solution {
        //用于记录当前遍历的<节点，次数>
        HashMap<String, Integer> memo = new HashMap();
        //存储相同的节点
        List<TreeNode> res = new ArrayList<>();
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            traverse(root);
            return res;
        }

        String traverse(TreeNode root) {
            //需要对当前遍历的节点做一个序列化操作
            if (root == null) {
                return "#";
            }
            //后序遍历顺序
            String left = traverse(root.left);
            String right = traverse(root.right);
            String subTree = left + "," + right + "," + root.val;
            int freq = memo.getOrDefault(subTree, 0);
            if (freq == 1) {
                res.add(root);
            }
            memo.put(subTree, freq+1);
            return subTree;
        }

    }
}
