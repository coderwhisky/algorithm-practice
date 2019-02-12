package org.buaa.nlp.cj.baseAlgorithm.tree;

import org.buaa.nlp.cj.Utils.BiTreeNode;

/**
 * Created by whisky-yonk on 10/18/2015.
 */
public class BiTreeNodesCount {
    public static void main(String[] args) {
        BiTreeNode root = new BiTreeNode(1);
        root.lchild = new BiTreeNode(2);
        root.lchild.lchild = new BiTreeNode(4);
        root.rchild = new BiTreeNode(3);
        int nodeNum = countNodes(root);
        System.out.println(nodeNum);
    }

    public static int countNodes(BiTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return countNodes(root.lchild) + countNodes(root.rchild) + 1;
        }
    }
}
