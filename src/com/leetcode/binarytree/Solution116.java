package com.leetcode.binarytree;

//填充每一个节点的下一个右侧节点的next指针（完全二叉树）
public class Solution116 {
    public static void main(String[] args) {
        Node root = new Node(1, new Node(2), new Node(3), null);
        Solution s = new Solution();
        s.connect(root);
        System.out.println(root.left.next.val);
        System.out.println(root.right.next);
    }
    static class Solution {
        public Node connect(Node root) {
            if(root == null) {
                return null;
            }
            connectTwoNode(root.left, root.right);
            return root;
        }

        //连接两个节点
        void connectTwoNode(Node node1, Node node2) {
            if(node1 == null || node2 == null) {
                return;
            }

            node1.next = node2;
            connectTwoNode(node1.left, node1.right);
            connectTwoNode(node2.left, node2.right);
            connectTwoNode(node1.right, node2.left);

        }
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
