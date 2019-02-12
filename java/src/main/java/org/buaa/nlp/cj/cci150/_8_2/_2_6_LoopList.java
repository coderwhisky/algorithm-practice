package org.buaa.nlp.cj.cci150._8_2;

import org.buaa.nlp.cj.cci150.CCINode;

/**
 * Created by Administrator on 2015/9/6.
 */
public class _2_6_LoopList {
    public static CCINode findLoopBegin(CCINode head) {
        if (head == null || head.next == null) {
            return null;
        }
        CCINode slow = head;
        CCINode fast = head;

        // find the meet node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // there is no loop
        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        /*
        * -------------------
        *              |    |->meet node
        *              ------
        * the length of the circle is R
        * the list head to loop begin is L
        * the meet node to the loop begin is x
        * then we can conducted that :
        * the slow point goes L+x steps
        * and the fast point goes 2(L+x) steps
        * then (2(L+x)-(L+x))%R=0, this means that (L+x)%R=0;
        * */
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        CCINode head = new CCINode(1);
        head.next = new CCINode(2);
        head.next.next = new CCINode(3);
        head.next.next.next = new CCINode(4);
        CCINode meet = new CCINode(5);
        head.next.next.next.next = meet;
        head.next.next.next.next.next = new CCINode(6);
        head.next.next.next.next.next.next = new CCINode(7);
        head.next.next.next.next.next.next.next = meet;
        CCINode result = findLoopBegin(head);
        System.out.print(result.val);
    }
}
