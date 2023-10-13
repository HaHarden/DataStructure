package com.leetcode.binarytree;

import com.leetcode.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution654 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        Solution s = new Solution();
        TreeNode treeNode = s.constructMaximumBinaryTree(nums);
        System.out.println(treeNode.val);
        System.out.println(treeNode.left.val);
        System.out.println(treeNode.right);

    }

    /**
     * 我的思路：在切割数组时，必须要用List，但是int数组转list很耗时
     * 改进：
     *  被递归的函数接收三个参数，build(int[] nums, int lo, int hi) 将要切割的左右位置传递进来，就可以实现数组切割
     */
    static class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if(nums.length == 0) {
                return null;
            }
            List<Integer> ints = Arrays.stream(nums).boxed().collect(Collectors.toList());
            TreeNode treeNode = constructMaximumBinaryTree(ints);
            return treeNode;
        }

        //找到数组中的最大值
        Integer max(List<Integer> nums) {
            Integer max = -1;
            for (int num : nums) {
                if(num > max)
                    max = num;
            }
            return max;
        }

        public TreeNode constructMaximumBinaryTree(List<Integer> nums) {
            if(nums.isEmpty()) {
                return null;
            }
            Integer max = max(nums);
            //用最大值构造根节点
            TreeNode root = new TreeNode(max);
            //分割数组
            int maxIndex = nums.indexOf(max);
            List<Integer> left = nums.subList(0, maxIndex);
            List<Integer> right = nums.subList(maxIndex + 1, nums.size());
            //对分割后的左右两个数组分别构造最大二叉树
            //左边数组构造的二叉树指向root.left，右边数组构造的二叉树指向root.right
            root.left = constructMaximumBinaryTree(left);
            root.right = constructMaximumBinaryTree(right);
            return root;
        }

        //省去int数组转换list的操作
        public TreeNode constructMaximumBinaryTree2(int[] nums) {
            return build(nums, 0, nums.length);
        }

        TreeNode build(int[] nums, int lo, int hi) {
            if(lo >= hi) {
                return null;
            }
            //找到最大值
            int max = Integer.MIN_VALUE;
            int index = -1;
            for(int i=lo; i<hi; i++) {
                if(nums[i] > max) {
                    index = i;
                    max = nums[i];
                }
            }
            TreeNode root = new TreeNode(max);
            root.left = build(nums, lo, index);
            root.right = build(nums, index+1, hi);
            return root;
        }


    }
}
