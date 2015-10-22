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
            return false;
        else
            return find(root.lchild, node) || find(root.rchild, node);
    }
}
