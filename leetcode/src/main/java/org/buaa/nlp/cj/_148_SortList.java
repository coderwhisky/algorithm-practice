package org.buaa.nlp.cj;

/**
 * Created by whisky on 2015/5/20.
 */
public class _148_SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        return mergeSortList(head);
    }

    public ListNode mergeSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode left = mergeSortList(head);
        ListNode right = mergeSortList(slow);
        return merge(left, right);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode head = null;
        if (list1.val < list2.val) {
            head = list1;
            p1 = p1.next;
        } else {
            head = list2;
            p2 = p2.next;
        }
        ListNode lastOrder = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                lastOrder.next = p1;
                lastOrder = lastOrder.next;
                p1 = p1.next;
            } else {
                lastOrder.next = p2;
                lastOrder = lastOrder.next;
                p2 = p2.next;
            }
        }
        if (p1 != null)
            lastOrder.next = p1;
        else
            lastOrder.next = p2;
        return head;
    }

    public static void main(String[] args) {
        _148_SortList sortList148 = new _148_SortList();
        ListNode head = new ListNode(2);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l5;
        l5.next = l2;
        l2.next = l4;
        l4.next = l3;
//        l3.next = null;
        head.next = l1;
        ListNode p = sortList148.sortList(head);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
