package org.buaa.nlp.cj.baseAlgorithm.tree;

import org.buaa.nlp.cj.Utils.BiTreeNode;

/**
 * Created by Administrator on 2015/10/24.
 */
public class MaxDistance {
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

        int maxDistance = getMaxDistance(root, 0, 0);

        System.out.println(maxDistance);
    }

    public static int getMaxDistance(BiTreeNode root, int maxLeft, int maxRight) {
        if (root == null)
            return 0;
        int maxLL = 0, maxLR = 0, maxRL = 0, maxRR = 0;
        int maxDistLeft = 0, maxDistRight = 0;
        if (root.lchild != null) {
            maxDistLeft = getMaxDistance(root.lchild, maxLL, maxLR);
            maxLeft = Math.max(maxLL, maxLR) + 1;
        } else {
            maxDistLeft = 0;
            maxLeft = 0;
        }

        if (root.rchild != null) {
            maxDistRight = getMaxDistance(root.rchild, maxRL, maxRR);
            maxRight = Math.max(maxRL, maxRR) + 1;
        }else {
            maxDistRight = 0;
            maxRight = 0;
        }
        return Math.max(Math.max(maxDistLeft, maxDistRight), maxLeft + maxRight +1);
    }
}
