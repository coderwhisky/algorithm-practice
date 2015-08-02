package org.buaa.nlp.cj;

/**
 * Created by Administrator on 2015/5/21.
 */
public class _92_ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m==n)
            return head;
        ListNode prev = head;
        ListNode newHead = head;
        int count = 1;
        for (int i = 1; i < m; i++) {
            prev = newHead;
            newHead = newHead.next;
        }
        ListNode curr = newHead;
        ListNode next = newHead;
        while (count <= (n-m+1)) {
            next = curr.next;
            prev.next = curr;
            curr.next = newHead;
            newHead = curr;
            curr = next;
            count ++;
        }
        return head;
    }
}
