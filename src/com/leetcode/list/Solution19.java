package com.leetcode.list;

//19.删除链表的倒数第N个节点
public class Solution19 {
    static class Solution {
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode node = findNthFromEnd(dummy, n + 1);
            node.next = node.next.next;
            return dummy.next;
        }

        public static ListNode findNthFromEnd(ListNode head, int n) {
            ListNode p1 = head, p2 = head;
            int count = 0;
            while (p1 != null) {
                if(count >= n) {
                    p2 = p2.next;
                }
                count++;
                p1 = p1.next;
            }
            return p2;
        }
        public static ListNode findNthFromEnd2(ListNode head, int n) {
            ListNode p1 = head;
            // p1 先走 k 步
            for (int i = 0; i < n; i++) {
                p1 = p1.next;
            }
            ListNode p2 = head;
            // p1 和 p2 同时走 n - k 步
            while (p1 != null) {
                p2 = p2.next;
                p1 = p1.next;
            }
            // p2 现在指向第 n - k + 1 个节点，即倒数第 k 个节点
            return p2;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1,new ListNode(3,new ListNode(5,new ListNode(7))));
        ListNode node2 = new ListNode(1,new ListNode(2));
        ListNode node3 = new ListNode(1);
        ListNode listNode = Solution.removeNthFromEnd(node3, 1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
