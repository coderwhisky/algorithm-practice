package org.buaa.nlp.cj.jobOnlineProgram.meicaiwang;

import java.util.List;

/**
 * Created by whisky-yonk on 10/23/2015.
 */
public class _2_ {
    public static void main(String[] args) {
//        LNode v0 = new LNode();v0.value = 10;v0.next = null;
        LNode v1 = new LNode();v1.value = 7;v1.next = null;
        LNode v2 = new LNode();v2.value = 9;v2.next = v1;
        LNode v3 = new LNode();v3.value = 8;v3.next = v2;
        LNode v4 = new LNode();v4.value = 4;v4.next = v3;
        LNode v5 = new LNode();v5.value = 1;v5.next = v4;
        LNode v6 = new LNode();v6.value = 6;v6.next = v5;
        LNode v7 = new LNode();v7.value = 3;v7.next = v6;
        LNode v8 = new LNode();v8.value = 2;v8.next = v7;
//        LNode v9 = new LNode();v2.value = 9;v2.next = v1;
        LNode p = v8;
        while (p != null) {
            System.out.print(p.value + " ");
            p = p.next;
        }
        System.out.println();
        LNode list = reverseLinkedList(v8);
        p = list;
        while (p != null) {
            System.out.print(p.value + " ");
            p = p.next;
        }

    }
    static class LNode{
        public int value;
        public LNode next;
    }
    public static LNode reverseLinkedList(LNode list)
    {
        // INSERT YOUR CODE HERE
        if (list == null || list.next == null || list.next.next == null) {
            return list;
        }

        LNode fast = list.next;
        LNode low = list;

        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next;
            fast = fast.next;
            low = low.next;
        }

        LNode prev = low.next;
        LNode cur = prev.next;
        while (cur != null) {
            prev.next = cur.next;
            cur.next = low.next;
            low.next = cur;
            cur = prev.next;
        }
        return list;
    }
}
