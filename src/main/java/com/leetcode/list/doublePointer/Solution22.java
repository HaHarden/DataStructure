package com.leetcode.list.doublePointer;

//剑指Offer22.单链表的倒数第k个节点
public class Solution22 {
    static class Solution {
        //双指针操作
        public static ListNode getKthFromEnd(ListNode head, int k) {
            ListNode p1 = head, p2 = head;
            int count = 0;
            while (p1 != null) {
                if(count >= k) {
                    p2 = p2.next;
                }
                count++;
                p1 = p1.next;
            }
            return p2;
        }

        public static void main(String[] args) {
            ListNode node = new ListNode(1,new ListNode(3,new ListNode(5,new ListNode(7))));
            ListNode kthFromEnd = Solution.getKthFromEnd(node, 4);
            System.out.println(kthFromEnd.val);
        }

        static class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }
    }
}
