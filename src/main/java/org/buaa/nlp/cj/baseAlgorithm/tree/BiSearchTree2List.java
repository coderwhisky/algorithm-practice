package org.buaa.nlp.cj.baseAlgorithm.tree;

import org.buaa.nlp.cj.Utils.BiTreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by whisky-yonk on 10/18/2015.
 */
public class BiSearchTree2List {
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

        BiTreeNode head = toList(root);
        BiTreeNode p = head.rchild;
        while (p != null) {
            p.visit();
            p = p.rchild;
        }
    }

    public static BiTreeNode toList(BiTreeNode root) {
        Stack<BiTreeNode> stack = new Stack<>();
        BiTreeNode p = root;
        BiTreeNode prev = new BiTreeNode(), cur = null;
        BiTreeNode head = prev;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.lchild;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                cur = p;
                prev.rchild = cur;
                cur.lchild = prev;
                p = p.rchild;
                prev = prev.rchild;
            }
        }
        return head;
    }
}
