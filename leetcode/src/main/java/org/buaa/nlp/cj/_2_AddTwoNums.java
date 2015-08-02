package org.buaa.nlp.cj;

/**
 * Created by whisky on 2015/5/25.
 */
public class _2_AddTwoNums {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, p3;
        ListNode newHead = new ListNode(0);
        p3 = newHead;
        int carry = 0;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                carry += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }
            p3.next = new ListNode(carry % 10);
            p3 = p3.next;
            carry /= 10;
        }
        if (carry == 1) {
            p3.next = new ListNode(1);
        }
        return newHead.next;
    }
}
