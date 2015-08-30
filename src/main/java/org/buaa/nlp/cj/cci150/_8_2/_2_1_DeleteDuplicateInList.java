package org.buaa.nlp.cj.cci150._8_2;

import org.buaa.nlp.cj.cci150.CCINode;
import org.buaa.nlp.cj.concurrentprogram.comsumerproducer.Info;
import org.buaa.nlp.cj.leetcode.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by whisky-yonk on 8/30/2015.
 */
public class _2_1_DeleteDuplicateInList {
    public void deleteDuplicate(CCINode head) {
        Map<Integer, Boolean> items = new HashMap<Integer, Boolean>();
        CCINode prev = head;
        CCINode pnode = prev.next;
        items.put(prev.getVal(), true);
        while (pnode != null) {
            if (items.containsKey(pnode.val)) {
                prev.next = pnode.next;
                pnode = prev.next;
            } else {
                items.put(pnode.val, true);
                prev = pnode;
                pnode = prev.next;
            }
        }
    }

    public static void main(String[] args) {
        _2_1_DeleteDuplicateInList deleteDuplicateInList = new _2_1_DeleteDuplicateInList();
        CCINode head = new CCINode(1);
        head.next = new CCINode(2);
        head.next.next = new CCINode(2);
        head.next.next.next = new CCINode(3);
        deleteDuplicateInList.deleteDuplicate(head);
        head.printList();
    }
}
