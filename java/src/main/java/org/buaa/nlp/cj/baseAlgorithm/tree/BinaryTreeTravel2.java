package org.buaa.nlp.cj.baseAlgorithm.tree;

import org.buaa.nlp.cj.Utils.BiTreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by whisky-yonk on 10/18/2015.
 */
public class BinaryTreeTravel2 {
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

        System.out.print("pre Travel: ");
        preTravel(root);
        System.out.println();

        System.out.print("in order travel: " );
        inTravel(root);
        System.out.println();

        System.out.print("post order travel:");
        postTravel(root);
        System.out.println();

        System.out.print("level travel");
        levelTravel(root);
        System.out.println();
    }

    /**
     * 非递归前序遍历
     * @param root
     */
    public static void preTravel(BiTreeNode root) {
        Stack<BiTreeNode> stack = new Stack<BiTreeNode>();
        BiTreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p.visit();
                p = p.lchild;
            }

            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.rchild;
            }
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void inTravel(BiTreeNode root) {
        BiTreeNode p = root;
        Stack<BiTreeNode> stack = new Stack<BiTreeNode>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.lchild;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p.visit();
                p = p.rchild;
            }
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void postTravel(BiTreeNode root) {
        BiTreeNode p = root;
        BiTreeNode last = null;
        Stack<BiTreeNode> stack = new Stack<BiTreeNode>();
        while (p != null) {
            while (p.lchild != null) {
                stack.push(p);
                p = p.lchild;
            }
            while (p != null && (p.rchild == null || p.rchild == last)) {
                p.visit();
                last = p;
                if (stack.isEmpty()) {
                    return;
                }
                p = stack.pop();
            }
            stack.push(p);
            p = p.rchild;
        }
    }

    /**
     * 层次遍历
     * @param root
     */
    public static void levelTravel(BiTreeNode root) {
        LinkedList<BiTreeNode> queue = new LinkedList<BiTreeNode>();
//        queue.offer(root);
        queue.addLast(root);
        BiTreeNode p = null;
        while (!queue.isEmpty()) {
            p = queue.removeFirst();
            if (p != null) {
                p.visit();
                if (p.lchild != null) {
//                    queue.offer(p.lchild);
                    queue.addLast(p.lchild);
                }
                if (p.rchild != null) {
//                    queue.offer(p.rchild);
                    queue.addLast(p.rchild);
                }
            }
        }
    }
}
