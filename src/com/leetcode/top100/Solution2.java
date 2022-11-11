package com.leetcode.top100;

import com.leetcode.list.recursion.Solution25;

/**
 * 2.两数相加
 * 两个指针   虚拟节点
 */
public class Solution2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(3)));
        ListNode l2 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode l3 = new ListNode(9,new ListNode(9,new ListNode(9)));
        ListNode l4 = new ListNode(9,new ListNode());
        ListNode listNode = addTwoNumbers(l3, l4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        //进位
        int carry = 0;
        while (p1 != null || p2 != null || carry > 0) {
            int val = carry;
            if(p1 != null) {
                val += p1.val;
                p1 = p1.next;
            }
            if(p2 != null) {
                val += p2.val;
                p2 = p2.next;
            }
            carry = val / 10;
            val = val % 10;
            p.next = new ListNode(val);
            p = p.next;
        }
        return dummy.next;
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
