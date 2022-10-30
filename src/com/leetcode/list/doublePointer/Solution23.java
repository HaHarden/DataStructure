package com.leetcode.list.doublePointer;


import java.util.*;

//合并k个升序链表
public class Solution23 {

    static class Solution {
        //我的方法：分割k个链表，将每个链表的值取出来放到一个List内，进行从小到大排序，然后将List内的值串成一个链表
        public static ListNode mergeKLists(ListNode[] lists) {
            //结果链表头节点
            ListNode dummy = new ListNode(-1);
            LinkedList<Integer> result = new LinkedList<>();
            for (ListNode list : lists) {
                //将各链表的值放到一个有序的List内
                result.addAll(splitListNode(list));
                //将有序list生成新链表
            }
            Collections.sort(result);
//            result.forEach(System.out::println);
            if (result.isEmpty()) {
                return null;
            } else {
                return mergeList(result);
            }
        }

        static LinkedList<Integer> splitListNode(ListNode list) {
            LinkedList<Integer> result = new LinkedList<>();
            //指针
            ListNode p = list;
            while (p != null) {
                result.add(p.val);
                p = p.next;
            }
            return result;
        }

        static ListNode mergeList(LinkedList<Integer> lists) {
            ListNode dummy = new ListNode(-1), p = dummy;
            for (int i = 0; i < lists.size(); i++) {
                ListNode node = new ListNode(lists.get(i));
                p.next = node;
                p = p.next;
            }
            return dummy.next;
        }

        //拉不拉东：使用优先级队列(二叉堆)求解 最小堆
        public static ListNode mergeKLists2(ListNode[] lists) {
            ListNode dummy = new ListNode(-1), p = dummy;
            PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b)->(a.val-b.val));
            for (ListNode head : lists) {
                if(head != null) {
                    queue.add(head);
                }
            }
            while (!queue.isEmpty()) {
                //取出最小值
                ListNode node = queue.poll();
                p.next = node;
                if(node.next != null) {
                    queue.add(node.next);
                }
                p = p.next;
            }
            return dummy.next;
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

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(2, new ListNode(5)));
        ListNode list3 = new ListNode();
        ListNode[] lists = new ListNode[]{list, list2};
        ListNode[] lists2 = new ListNode[]{};
        ListNode listNode = Solution.mergeKLists2(lists);
        ListNode listNode2 = Solution.mergeKLists(lists2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
