package org.buaa.nlp.cj.baseAlgorithm.tree;

import org.buaa.nlp.cj.Utils.BiTreeNode;

/**
 * Created by whisky-yonk on 10/21/2015.
 */
public class CommonFatherBT {
    public static void main(String[] args) {

    }

    public static boolean find(BiTreeNode root, BiTreeNode node) {
        if (root == null) {
            return false;
        }
        if (root == node)
            return true;
        else
            return find(root.lchild, node) || find(root.rchild, node);
    }

    public static BiTreeNode commonFather(BiTreeNode root, BiTreeNode node1, BiTreeNode node2) {
        if (root == null || root.lchild == null || root.rchild == null)
            return null;
        if (find(root.lchild, node1) && find(root.rchild, node2)) {
            return root;
        } else if (find(root.lchild, node1) && find(root.lchild, node2)) {
            return commonFather(root.lchild, node1, node2);
        } else {
            return commonFather(root.rchild, node1, node2);
        }
    }
}
