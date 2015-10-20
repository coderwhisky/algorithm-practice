package org.buaa.nlp.cj.baseAlgorithm.tree;

import org.buaa.nlp.cj.Utils.BiTreeNode;

import java.util.Stack;

/**
 * Created by whisky-yonk on 10/18/2015.
 */
public class CountNoChildNodes {
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

        int count = noChildNodes(root);
        System.out.println(count);
    }

    public static int noChildNodes(BiTreeNode root) {
        int count = 0;
        Stack<BiTreeNode> stack = new Stack<>();
        BiTreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                if (p.lchild == null && p.rchild == null) {
                    count++;
                }
                p = p.lchild;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.rchild;
            }
        }
        return count;
    }
}
