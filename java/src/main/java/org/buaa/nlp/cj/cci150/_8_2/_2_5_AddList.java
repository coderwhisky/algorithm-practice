package org.buaa.nlp.cj.cci150._8_2;

import org.buaa.nlp.cj.cci150.CCINode;

/**
 * Created by whisky-yonk on 9/2/2015.
 */
public class _2_5_AddList {
    // =========================method 1 start: no recursive
    public CCINode addList(CCINode node1, CCINode node2) {
        CCINode result = new CCINode();
        CCINode p1 = node1;
        CCINode p2 = node2;
        int shift = 0;
        int cur  = 0;
        boolean flag = true;
        CCINode prev = new CCINode();
        while (p1 != null && p2 != null) {
            cur = (p1.val + p2.val + shift) % 10;
            shift = (p1.val + p2.val + shift) / 10;
            CCINode p = new CCINode(cur);
            if (flag) {
                result = p;
                flag = false;
                prev = result;
            } else {
                prev.next = p;
                prev = prev.next;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null) {
            cur = (p1.val + shift) % 10;
            shift = (p1.val + shift) / 10;
            CCINode p = new CCINode(cur);
            if (flag) {
                result = p;
                flag = false;
            }
            prev.next = p;
            prev = p;
            p1 = p1.next;
        }
        while (p2 != null) {
            cur = (p2.val + shift) % 10;
            shift = (p2.val + shift) / 10;
            CCINode p = new CCINode(cur);
            if (flag) {
                result = p;
                flag = false;
            }
            prev.next = p;
            prev = p;
            p2 = p2.next;
        }
        if (shift > 0) {
            CCINode p = new CCINode(shift);
            prev.next = p;
            prev = p;
        }
        return result;
    }
    // =========================method 1 end: no recursive

    // =========================method 2 start: recursive
    public CCINode addList2(CCINode node1, CCINode node2, int carry) {
        if (node1 == null && node2 == null && carry == 0)
            return null;
        CCINode result = new CCINode();

        if (node1 == null && node2 == null && carry > 0)
            result.val = carry;

        int value = carry;
        if (node1 != null)
            value += node1.val;
        if (node2 != null)
            value += node2.val;

        result.val = value % 10;
        CCINode more = addList2(node1 == null ? null : node1.next,
                node2 ==null ? null : node2.next, value > 10 ? 1 : 0);

        result.next = more;
        return result;
    }
    // =========================method 2 end: recursive

    public static void main(String[] args) {
        CCINode node1 = new CCINode(7);
        node1.next = new CCINode(1);
        node1.next.next = new CCINode(6);
        CCINode node2 = new CCINode(5);
        node2.next = new CCINode(9);
        node2.next.next = new CCINode(5);
        node2.next.next.next = new CCINode(9);

        CCINode result = new _2_5_AddList().addList2(node1, node2, 0);
        result.printList();
    }
}
