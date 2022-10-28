package com.leetcode.list;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//有序链表合并
public class Solution21 {

    static class Solution {
        public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            //虚拟头节点 ，p是结果list的指针
            ListNode dummy = new ListNode(-1), p = dummy;
            //p1和p2是两个list的指针
            ListNode p1 = list1, p2 = list2;
            while (p1 != null && p2 != null) {
                if(p1.val > p2.val) {
                    p.next = p2;
                    p2 = p2.next;
                }
                else {
                    p.next = p1;
                    p1 = p1.next;
                }
                p = p.next;
            }
            if(p1 != null) {
                p.next = p1;
            }
            if(p2 != null) {
                p.next = p2;
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode list2 = new ListNode(1);
        ListNode listNode = Solution.mergeTwoLists(list1, list2);
    }


    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
