package org.buaa.nlp.cj.baseAlgorithm.tree;

import org.buaa.nlp.cj.Utils.BiTreeNode;

/**
 * Created by whisky-yonk on 10/21/2015.
 */
public class StructCmpBT {
    public static void main(String[] args) {
        BiTreeNode root1 = new BiTreeNode(1);
        root1.lchild = new BiTreeNode(2);
        root1.lchild.lchild = new BiTreeNode(4);
        root1.lchild.rchild = new BiTreeNode(5);
        root1.lchild.rchild.rchild = new BiTreeNode(9);
        root1.lchild.lchild.lchild = new BiTreeNode(8);
        root1.rchild = new BiTreeNode(3);
        root1.rchild.lchild = new BiTreeNode(6);
        root1.rchild.rchild = new BiTreeNode(7);
        root1.rchild.rchild.lchild = new BiTreeNode(10);

        BiTreeNode root = new BiTreeNode(1);
        root.lchild = new BiTreeNode(2);
        root.lchild.lchild = new BiTreeNode(4);
        root.lchild.rchild = new BiTreeNode(5);
        root.lchild.rchild.rchild = new BiTreeNode(9);
        root.lchild.lchild.lchild = new BiTreeNode(8);
        root.rchild = new BiTreeNode(3);
        root.rchild.lchild = new BiTreeNode(6);
        root.rchild.rchild = new BiTreeNode(7);
//        root.rchild.rchild.lchild = new BiTreeNode(10);

        System.out.println(structCmp(root1, root));

    }

    public static boolean structCmp(BiTreeNode r1, BiTreeNode r2) {
        if (r1 == null || r2 == null)
            return r1 == null && r2 == null;
        boolean lcmp = structCmp(r1.lchild, r2.lchild);
        boolean rcmp = structCmp(r1.rchild, r2.rchild);
        return lcmp && rcmp;
    }
}
