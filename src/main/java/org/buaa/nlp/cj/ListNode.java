package org.buaa.nlp.cj;

/**
 * Created by Administrator on 2015/5/17.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
    public void listPrint() {
        ListNode p = this;
        while (p != null) {
            System.out.print(p.val);
            System.out.print(" ");
            p = p.next;
        }
        System.out.println();
    }
}
