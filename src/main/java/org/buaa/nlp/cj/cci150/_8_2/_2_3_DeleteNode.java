package org.buaa.nlp.cj.cci150._8_2;

import org.buaa.nlp.cj.cci150.CCINode;

/**
 * Created by whisky-yonk on 8/30/2015.
 */
public class _2_3_DeleteNode {
    /**
     * 注意：因为只能访问指定的节点， 所以实际上不能不能访问头结点，
     * 也不能访问除该节点后继节点以外的任意节点，
     * 做法就是将该节点的后继节点复制到当前节点，然后删除当前节点
     * 所以如果该节点为空或者该节点的后继节点为空
     * @param node
     * @return
     */
    public boolean delete(CCINode node) {
        if (node == null || node.next == null)
            return false;
        node.val = node.next.val;
        node.next = node.next.next;
        return true;
    }
    public static void main(String[] args) {

    }
}
