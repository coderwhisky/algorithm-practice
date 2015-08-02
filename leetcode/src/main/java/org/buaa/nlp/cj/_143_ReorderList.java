package org.buaa.nlp.cj;

/**
 * Created by whisky on 2015/5/23.
 */
public class _143_ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        ListNode fast = head, slow = head;
        ListNode leftTail = head;
        while (fast.next != null && fast.next.next != null ) {
            leftTail = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode prev = slow.next, pnext = null;
        //后半部分逆转
        while (prev != null) {
            pnext = prev.next;
            prev.next = slow;
            leftTail.next = prev;
            slow = prev;
            prev = pnext;
        }

        prev = head;
        while (slow != null) {
            pnext = prev.next;
            fast = slow.next;
            slow.next = pnext;
            prev.next = slow;
            prev = pnext;
            slow = fast;
        }
    }
}
