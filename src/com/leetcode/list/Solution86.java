package com.leetcode.list;


//分隔链表
public class Solution86 {

    static public ListNode partition(ListNode head, int x) {
        //小于x的链表 虚拟头节点
        ListNode dummy1 = new ListNode(-1);
        //大于等于x的链表 虚拟头节点
        ListNode dummy2 = new ListNode(-1);
        //小于x的链表的指针
        ListNode p1 = dummy1;
        //大于等于x的链表 的指针
        ListNode p2 = dummy2;
        //给定链表的指针
        ListNode p = head;

        while (p != null) {
            if(p.val < x) {
                p1.next = p;
                p1 = p1.next;
            }
            else {
                p2.next = p;
                p2 = p2.next;
            }
//            p = p.next;
            //断开原链表中每个节点的next指针
            ListNode tmp = p.next;
            p.next = null;
            p = tmp;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        ListNode partition = Solution86.partition(list, 3);
        while (partition != null) {
            System.out.println(partition.val);
            partition = partition.next;
        }
    }


   static public class ListNode {
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
