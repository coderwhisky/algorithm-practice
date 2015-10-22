package org.buaa.nlp.cj.baseAlgorithm.tree;

import org.buaa.nlp.cj.Utils.BiTreeNode;

/**
 * Created by whisky-yonk on 10/21/2015.
 */
public class IsBalanceBT {
    public static void main(String[] args) {
        BiTreeNode root = new BiTreeNode(1);
        root.lchild = new BiTreeNode(2);
        root.lchild.lchild = new BiTreeNode(4);
        root.lchild.rchild = new BiTreeNode(5);
        root.lchild.rchild.rchild = new BiTreeNode(9);
        root.lchild.lchild.lchild = new BiTreeNode(8);
        root.rchild = new BiTreeNode(3);
        root.rchild.lchild = new BiTreeNode(6);
        root.rchild.rchild = new BiTreeNode(7);
        root.rchild.rchild.lchild = new BiTreeNode(10);
        System.out.println(isBalance(root));
    }

    /**
     * return -1 if is not balance
     * @param root
     * @return
     */
    public static int isBalance(BiTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = isBalance(root.lchild);
        int right = isBalance(root.rchild);
        if (left ==-1 || right == -1) {
            return -1;
        } else if (Math.abs(left - right) <= 1) {
            return Math.max(left, right) + 1;
        } else {
            return -1;
        }
    }
}
