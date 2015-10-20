package org.buaa.nlp.cj.Utils;

/**
 * 二叉树节点
 * Created by whisky-yonk on 8/31/2015.
 */
public class BiTreeNode {
    public int val;
    public BiTreeNode lchild = null;
    public BiTreeNode rchild = null;

    public BiTreeNode() {
    }

    public BiTreeNode(int val) {
        this.val = val;
    }

    public void visit() {
        System.out.print(this.val+ " ");
    }
}
