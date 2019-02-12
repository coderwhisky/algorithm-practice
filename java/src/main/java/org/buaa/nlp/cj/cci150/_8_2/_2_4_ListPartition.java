package org.buaa.nlp.cj.cci150._8_2;

import org.buaa.nlp.cj.cci150.CCINode;

/**
 * Created by whisky-yonk on 8/30/2015.
 */
public class _2_4_ListPartition {
    public CCINode partition(CCINode node, int x) {
        CCINode beforeStart = null;
        CCINode afterStart = null;
        while (node != null) {
            CCINode next = node.next;
            if (node.val < x) {
                node.next = beforeStart;
                beforeStart = node;
            } else {
                node.next = afterStart;
                afterStart = node;
            }
            node = next;
        }

        if (beforeStart == null)
            return afterStart;

        CCINode head = beforeStart;
        while (beforeStart.next != null) {
            beforeStart = beforeStart.next;
        }
        beforeStart.next = afterStart;
        return head;
    }
    public static void main(String[] args) {
        CCINode head = new CCINode(10);
        head.next = new CCINode(20);
        head.next.next = new CCINode(3);
        head.next.next.next = new CCINode(2);
        head.next.next.next.next = new CCINode(1);

        _2_4_ListPartition listPartition = new _2_4_ListPartition();
        head = listPartition.partition(head, 3);
        head.printList();
    }
}
