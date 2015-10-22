package org.buaa.nlp.cj.baseAlgorithm.tree;

import org.buaa.nlp.cj.Utils.BiTreeNode;

import java.util.Stack;

/**
 * Created by whisky-yonk on 10/21/2015.
 */
public class MirrorOfBT {
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

        root = mirror(root);
        BinaryTreeTravel2.inTravel(root);
        System.out.println();
        BinaryTreeTravel2.preTravel(root);

        root = new BiTreeNode(1);
        root.lchild = new BiTreeNode(2);
        root.lchild.lchild = new BiTreeNode(4);
        root.lchild.rchild = new BiTreeNode(5);
        root.lchild.rchild.rchild = new BiTreeNode(9);
        root.lchild.lchild.lchild = new BiTreeNode(8);
        root.rchild = new BiTreeNode(3);
        root.rchild.lchild = new BiTreeNode(6);
        root.rchild.rchild = new BiTreeNode(7);
        root.rchild.rchild.lchild = new BiTreeNode(10);

        root = mirror2(root);
        System.out.println();
        BinaryTreeTravel2.inTravel(root);
        System.out.println();
        BinaryTreeTravel2.preTravel(root);
    }

    /**
     * 求二叉树的镜像
     * @param root
     * @return
     */
    public static BiTreeNode mirror(BiTreeNode root) {
        if (root == null)
            return null;
        if (root.lchild == null && root.rchild == null) {
            return root;
        }
//        else  {
//            BiTreeNode tmp = root.lchild;
//            root.lchild = root.rchild;
//            root.rchild = tmp;
//        }
        BiTreeNode lmirror = mirror(root.lchild);
        BiTreeNode rmirror = mirror(root.rchild);
        root.lchild = rmirror;
        root.rchild = lmirror;
        return root;
    }

    /**
     * 非递归法求镜像
     * @param root
     * @return
     */
    public static BiTreeNode mirror2(BiTreeNode root) {
        if (root == null)
            return null;
        Stack<BiTreeNode> stack = new Stack<>();
        BiTreeNode p = root;
        stack.push(p);

        while (!stack.isEmpty()) {
            p = stack.pop();
            if (p.lchild != null || p.rchild != null) {
                BiTreeNode tmp = p.lchild;
                p.lchild = p.rchild;
                p.rchild = tmp;
            }

            if (p.lchild != null)
                stack.push(p.lchild);
            if (p.rchild != null)
                stack.push(p.rchild);
        }
        return root;
    }
}
