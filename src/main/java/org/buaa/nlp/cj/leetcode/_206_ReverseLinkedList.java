package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/5/15.
 */
public class _206_ReverseLinkedList {
    /**
     * linkedList has head node
     */
    public class Solution {
        public org.buaa.nlp.cj.ListNode reverseList(org.buaa.nlp.cj.ListNode head) {
            if (head == null || head.next == null || head.next.next == null)
                return head;
            org.buaa.nlp.cj.ListNode prev = head.next.next;
            head.next.next = null;
            while (prev != null) {
                org.buaa.nlp.cj.ListNode pnext = prev.next;
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
            public org.buaa.nlp.cj.ListNode reverseList(org.buaa.nlp.cj.ListNode head) {
                if (head == null || head.next == null)
                    return head;
                org.buaa.nlp.cj.ListNode prev = head.next;
                head.next = null;
                while (prev != null) {
                    org.buaa.nlp.cj.ListNode pnext = prev.next;
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
        org.buaa.nlp.cj.ListNode head = new org.buaa.nlp.cj.ListNode(1);
        head.next = new ListNode(2);
        solution2.reverseList(head);
        System.out.print(head.toString());
    }
}