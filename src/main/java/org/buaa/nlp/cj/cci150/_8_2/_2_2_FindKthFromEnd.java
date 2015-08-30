package org.buaa.nlp.cj.cci150._8_2;

import org.buaa.nlp.cj.cci150.CCINode;

/**
 * Created by whisky-yonk on 8/30/2015.
 */
public class _2_2_FindKthFromEnd {
    public CCINode nthToLast(CCINode head, int k) {
        if (k <= 0)
            return null;
        CCINode low = head;
        CCINode fast = head;
        while (k > 1) {
            if (fast == null)
                return null;
            fast = fast.next;
            k--;
        }

        while (fast.next != null) {
            low = low.next;
            fast = fast.next;
        }

        return low;
    }

    public static void main(String[] args) {
        CCINode head = new CCINode(1);
        head.next = new CCINode(2);
        head.next.next = new CCINode(3);
        head.next.next.next = new CCINode(4);

        _2_2_FindKthFromEnd findKthFromEnd = new _2_2_FindKthFromEnd();
        CCINode kthToLast = findKthFromEnd.nthToLast(head, 1);
        System.out.println(kthToLast.val);
    }
}
