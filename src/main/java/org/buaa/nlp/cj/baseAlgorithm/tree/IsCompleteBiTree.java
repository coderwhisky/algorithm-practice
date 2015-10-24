package org.buaa.nlp.cj.baseAlgorithm.tree;

import org.buaa.nlp.cj.Utils.BiTreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Administrator on 2015/10/24.
 */
public class IsCompleteBiTree {
    public static boolean isCompleteBiTree(BiTreeNode root) {
        boolean ser = true;

        LinkedList<BiTreeNode> queue = new LinkedList<>();
        if (root == null)
            return false;
        queue.offer(root);
        boolean noTwoChild = false;
        while (!queue.isEmpty()) {
            BiTreeNode cur = queue.removeFirst();
            if (noTwoChild) {
                if (cur.lchild != null || cur.rchild != null) {
                    ser = false;
                    break;
                }
            } else {
                if (cur.lchild != null && cur.rchild != null) {
                    queue.offer(cur.lchild);
                    queue.offer(cur.rchild);
                } else if (cur.lchild != null) {
                    queue.offer(cur.lchild);
                    noTwoChild = true;
                } else if (cur.rchild != null) {
                    ser = false;
                    break;
                } else {
                    noTwoChild = true;
                }
            }
        }
        return ser;
    }
    public static void main(String[] args) {
        BiTreeNode root = new BiTreeNode(1);
        root.lchild = new BiTreeNode(2);
        root.lchild.lchild = new BiTreeNode(4);
        root.lchild.rchild = new BiTreeNode(5);
//        root.lchild.rchild.rchild = new BiTreeNode(9);
        root.lchild.lchild.lchild = new BiTreeNode(8);
        root.rchild = new BiTreeNode(3);
        root.rchild.lchild = new BiTreeNode(6);
        root.rchild.rchild = new BiTreeNode(7);
//        root.rchild.rchild.lchild = new BiTreeNode(10);

        System.out.println(isCompleteBiTree(root));

        Set<Integer> sss = new HashSet<>();
        sss.add(33);
    }
}
