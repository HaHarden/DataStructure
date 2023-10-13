package com.leetcode.list.recursion;

/**
 * 234.回文链表
 */
public class Solution234 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(2, new ListNode(3))));
        ListNode head2 = new ListNode(1,new ListNode(2,new ListNode(2)));
        System.out.println(isPalindrome(head));
        System.out.println(isPalindrome(head2));

    }

    /**
     * 先找到 链表的中点，再将中点开头的链表反转， 再和head开头的链表比较
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        ListNode midpoint = findMidpoint(head);
        //迭代反转，效率相对高
        ListNode reverse = reverse(midpoint);
        //递归反转，效率低
        ListNode reverse2 = reverse2(midpoint);
        while (reverse != null) {
            if(head.val != reverse.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }

    //快慢指针找中点，总数为奇数需要返回中点.next，因为中点不影响回文链表的判断，偶数就直接返回中点
    public static ListNode findMidpoint(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //fast不为null的时候跳出while循环，证明fast.next == null，所以此时fast指向最后一个节点，这种情况总数为奇数，需要返回fast.next
        if(fast != null) {
            return fast.next;
        }
        return slow;
    }
    //反转单链表可以递归，也可以迭代
    //迭代
    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //递归方式迭代
    public static ListNode reverse2(ListNode head) {
        while (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
