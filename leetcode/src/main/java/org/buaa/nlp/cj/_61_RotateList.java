package org.buaa.nlp.cj;

/**
 * Created by whisky on 2015/5/20.
 */
public class _61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null ||k <= 0)
            return head;
        ListNode slow = head, fast = head, countLen = head;
        int len = 0;
        while (countLen != null) {
            len ++;
            countLen = countLen.next;
        }
        k = k % len;
        for (int i = 0; i < k; i++)
            fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }


    public static void main(String[] args) {
        _61_RotateList rotateList61 = new _61_RotateList();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode head = rotateList61.rotateRight(l1, 2);
        System.out.println("rotated list:");
        head.listPrint();
//        while (head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }
    }
}
