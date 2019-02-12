package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/5/15.
 */
public class _206_ReverseLinkedList {
    /**
     * linkedList has head node
     */
    public class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null)
                return head;
            ListNode prev = head.next.next;
            head.next.next = null;
            while (prev != null) {
                ListNode pnext = prev.next;
                prev.next = head.next;
                head.next = prev;
                prev = pnext;
            }
            return head;
        }
    }

    /**
     * linked has no head node
     */
    public static class Solution2 {
            public ListNode reverseList(ListNode head) {
                if (head == null || head.next == null)
                    return head;
                ListNode prev = head.next;
                head.next = null;
                while (prev != null) {
                    ListNode pnext = prev.next;
                    prev.next = head;
                    head = prev;
                    prev = pnext;
                }
                return head;
            }
    }

    public static void main(String[] args) {
        _206_ReverseLinkedList reverseLinkedList206 = new _206_ReverseLinkedList();
        Solution2 solution2 = new Solution2();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        solution2.reverseList(head);
        System.out.print(head.toString());
    }
}