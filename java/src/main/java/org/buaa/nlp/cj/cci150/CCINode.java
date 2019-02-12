package org.buaa.nlp.cj.cci150;

/**
 * Created by whisky-yonk on 8/30/2015.
 */
public class CCINode {
    public int val;
    public CCINode next = null;

    public CCINode(){
        this.next = null;
    };

    public CCINode(int val) {
        this.val = val;
    }

    public void printList() {
        System.out.print(this.val);
        CCINode p = this.next;
        while (p != null) {
            System.out.print("->" + p.val);
            p = p.next;
        }
        System.out.println();
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public CCINode getNext() {
        return next;
    }

    public void setNext(CCINode next) {
        this.next = next;
    }

    public static void main(String[] args) {
        CCINode cciNode = new CCINode(2);
        cciNode.next = new CCINode(4);
        cciNode.printList();
    }
}
