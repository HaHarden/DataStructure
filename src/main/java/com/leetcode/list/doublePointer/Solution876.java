package com.leetcode.list.doublePointer;

//876.链表的中间节点
public class Solution876 {

    static class Solution {
        public static ListNode middleNode(ListNode head) {
            //快慢指针
            //慢指针走一步，快指针走两步，快指针走到尾部时满指针就指向了中点
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

    //判断链表是否含有环
    public static boolean containsCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，说明含有环
            if(fast == slow)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode head2 = new ListNode(1,new ListNode(2,new ListNode(3)));
        ListNode node = Solution.middleNode(head);
        ListNode node2 = Solution.middleNode(head2);
        System.out.println(node.val);
        System.out.println(node2.val);
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
