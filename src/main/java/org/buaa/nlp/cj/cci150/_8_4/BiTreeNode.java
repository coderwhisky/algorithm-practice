package org.buaa.nlp.cj.cci150._8_4;

/**
 * Created by whisky-yonk on 8/31/2015.
 */
public class BiTreeNode {
    public int val;
    public BiTreeNode lchild = null;
    public BiTreeNode rchild = null;

    public BiTreeNode(int val) {
        this.val = val;
    }

    public void travel(BiTreeNode root) {
        if (root == null)
            return;
        System.out.println();
    }
}
