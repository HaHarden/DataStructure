package com.leetcode.list.doublePointer;

import java.util.*;

//剑指 Offer II 022. 链表中环的入口节点
public class Solution022 {
    static class Solution {
        //我的方法：弄一个list缓存，遍历过的节点放到缓存里，当有一个节点第二次被遍历到时，就是环的起点
        public ListNode detectCycle(ListNode head) {
            List<ListNode> list = new ArrayList<>();
            ListNode p = head;
            while (p != null) {
                if(list.contains(p)) {
                    return p;
                }
                list.add(p);
                p = p.next;
            }
            return null;
        }

        public ListNode detectCycle2(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast)
                    break;
            }

            if(fast == null || fast.next == null) {
                return null;
            }

            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;

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
