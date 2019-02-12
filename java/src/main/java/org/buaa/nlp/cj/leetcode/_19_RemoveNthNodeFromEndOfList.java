package org.buaa.nlp.cj.leetcode;


/**
 * Created by Administrator on 2015/7/28.
 */
public class _19_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n==1)
            return null;
        if (n == 0)
            return head;

        ListNode fast = head;
        ListNode p = head;
        ListNode pre = head;
        while (--n > 0) {
            fast = fast.next;
        }
        boolean flag = false;
        while (fast.next != null) {
            fast = fast.next;
            p = p.next;
            if (flag) {
                pre = pre.next;
            }
            flag = true;
        }
        if (p == head)
            return head.next;
//        p.next = p.next.next;
        pre.next = p.next;
        p.next = null;
        return head;
    }

    public static void main(String[] args) {
        _19_RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new _19_RemoveNthNodeFromEndOfList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode p = removeNthNodeFromEndOfList.removeNthFromEnd(head, 4);
        p.listPrint();
    }
}
