package org.buaa.nlp.cj.cci150._8_4;

import java.util.Stack;

/**
 * 设计一个算法，找出二叉查找树中指定节点的“下一个”节点（也即中序后继），可以假定每个节点都含有指向父节点的链接
 * Created by Administrator on 2015/9/12.
 */
public class _4_6_NextNodeInBT {


    public static void main(String[] args) {
        _4_6_NextNodeInBT nextNodeInBT = new _4_6_NextNodeInBT();
        BiTreeNode root = new BiTreeNode(15);
        root.lchild = new BiTreeNode(10);
        root.rchild = new BiTreeNode(20);
        root.lchild.lchild = new BiTreeNode(4);
        root.lchild.rchild = new BiTreeNode(13);
        root.rchild.lchild = new BiTreeNode(18);
        root.rchild.rchild = new BiTreeNode(30);
        nextNodeInBT.nonRecursivePreOrder(root);
        System.out.println();
        nextNodeInBT.nonRecursiveInOrder(root);
        System.out.println();
        nextNodeInBT.nonRecursivePostOrder(root);
    }

    // this is practice for binary tree travel +++++ start
    public void nonRecursivePreOrder(BiTreeNode root) {
        Stack<BiTreeNode> stack = new Stack<BiTreeNode>();
        BiTreeNode p = root;
        while (p != null || stack.size() > 0) {
            while (p != null) {
                stack.push(p);
                System.out.print(p.val + " ");
                p = p.lchild;
            }

            if (stack.size() > 0) {
                p = stack.pop();
                p = p.rchild;
            }
        }
    }

    public void nonRecursiveInOrder(BiTreeNode root) {
        Stack<BiTreeNode> stack = new Stack<BiTreeNode>();
        BiTreeNode p = root;

        while (p != null || stack.size() > 0) {
            while (p != null) {
                stack.push(p);
                p = p.lchild;
            }

            if (stack.size() > 0) {
                p = stack.pop();
                System.out.print(p.val + " ");
                p = p.rchild;
            }
        }
    }

    public void nonRecursivePostOrder(BiTreeNode root) {
        BiTreeNode lastVisit = root;
        BiTreeNode p = root;
        Stack<BiTreeNode> stack = new Stack<BiTreeNode>();

        while (p != null || stack.size() > 0) {
            while (p.lchild != null) {
                stack.push(p);
                p = p.lchild;
            }

            while (p != null && (p.rchild == null || p.rchild == lastVisit)) {
                System.out.print(p.val +" ");
                lastVisit = p;
                if (stack.isEmpty()) {
                    return;
                }
                p = stack.pop();
            }

            stack.push(p);
            p = p.rchild;
        }
    }
    // this is practice for binary tree travel +++++ end
}
