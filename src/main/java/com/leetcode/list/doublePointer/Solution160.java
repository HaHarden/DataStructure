package com.leetcode.list.doublePointer;

import java.util.ArrayList;
import java.util.List;

/**
 * 160.相交链表
 */
public class Solution160 {

    static class Solution {

        //p1遍历完listA，接着从头遍历listB，p2遍历完listB，接着从头遍历listA，相当于两个链表逻辑上连载一起，
        //那么两个指针同步前进，可以同时到达共同起点
        public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p1 = headA, p2 = headB;
            while (p1 != p2) {
                if(p1 == null) {
                    p1 = headB;
                }
                else {
                    p1 = p1.next;
                }
                if(p2 == null) {
                    p2 = headA;
                }
                else {
                    p2 = p2.next;
                }
            }
            return p1;
        }

        //两个链表首尾相接，问题就变成了 找一个链表中环的起点
        public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
            ListNode headC = headA, p = headC;
            while (p != null) {
                p = p.next;
            }
            //lisA尾链接listB首
            p.next = headB;

            //找headC这个链表的环起点
            ListNode slow = headC, fast = headC;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast)
                    break;
            }
            //没有环
            if(fast == null || fast.next == null) {
                return null;
            }
            //slow或fast指向head，同步开始
            slow = headC;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;

        }

        public static ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
            ListNode p1 = headA, p2 = headB;
            int lenA = 0, lenB = 0;
            while (p1 != null) {
                lenA++;
                p1 = p1.next;
            }
            while (p2 != null) {
                lenB++;
                p2 = p2.next;
            }
            p1 = headA;
            p2 = headB;
            if(lenA > lenB) {
                for(int i=0;i<lenA-lenB;i++) {
                    p1 = p1.next;
                }
            }
            if(lenB > lenA) {
                for(int i=0;i<lenB-lenA; i++) {
                    p2 = p2.next;
                }
            }
            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        }

            //没做出来 通过：27/39
        public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
            ListNode p1 = headA, p2 = headB;
            List<ListNode> list = new ArrayList<>();
            while (p1 != null || p2 != null) {
                if(list.contains(p1)) {
                    return p1;
                }
                if(list.contains(p2)) {
                    return p2;
                }
                list.add(p1);
                list.add(p2);
                p1 = p1==null ? null : p1.next;
                p2 = p2==null ? null : p2.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {

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
