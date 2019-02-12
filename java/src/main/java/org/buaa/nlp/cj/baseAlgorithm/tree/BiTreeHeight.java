package org.buaa.nlp.cj.baseAlgorithm.tree;

import org.buaa.nlp.cj.Utils.BiTreeNode;

/**
 * Created by whisky-yonk on 10/18/2015.
 */
public class BiTreeHeight {
    public static void main(String[] args) {
        BiTreeNode root = new BiTreeNode(0);
        root.lchild = new BiTreeNode(1);
        root.lchild.lchild = new BiTreeNode(2);
        root.rchild = new BiTreeNode(3);
        root.rchild.rchild = new BiTreeNode(4);
        root.rchild.rchild.rchild = new BiTreeNode(5);
        int height = height(root);
        System.out.println(height);
    }

    public static int height(BiTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.lchild), height(root.rchild)) + 1;
        }
    }
}
