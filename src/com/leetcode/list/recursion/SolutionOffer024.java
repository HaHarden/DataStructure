package com.leetcode.list.recursion;


/**
 *剑指 Offer 24. 反转链表
 */
public class SolutionOffer024 {

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        //先把第二个节点开头的链表反转
        ListNode last = reverseList(head.next);
        //再把第一个节点接到反转链表的尾部
        head.next.next = head;
        //把第一个链表的next指向null
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(3,new ListNode(5,new ListNode(7))));
        ListNode reverse= reverseList(head);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
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
