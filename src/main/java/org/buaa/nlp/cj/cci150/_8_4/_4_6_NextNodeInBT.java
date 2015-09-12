package org.buaa.nlp.cj.cci150._8_4;

import java.util.Stack;

/**
 * 设计一个算法，找出二叉查找树中指定节点的“下一个”节点（也即中序后继），可以假定每个节点都含有指向父节点的链接
 * Created by Administrator on 2015/9/12.
 */
public class _4_6_NextNodeInBT {
    
    static class BiTreeNode2 {
        public int val;
        public BiTreeNode2 lchild = null;
        public BiTreeNode2 rchild = null;
        public BiTreeNode2 parent = null;

        public BiTreeNode2(int val) {
            this.val = val;
        }
    }

    /**
     * 找出指定结点的下一个结点
     * @param n
     * @return
     */
    public BiTreeNode2 inOrderSucc(BiTreeNode2 n) {
        if (n == null)
            return null;
        if (n.rchild != null) {
            return leftMostChild(n.rchild);
        } else {
            BiTreeNode2 q = n;
            BiTreeNode2 x = q.parent;
            while (x != null && x.lchild != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    public BiTreeNode2 leftMostChild(BiTreeNode2 n) {
        if (n == null)
            return null;
        while (n.lchild != null) {
            n = n.lchild;
        }
        return n;
    }

    public static void main(String[] args) {
        _4_6_NextNodeInBT nextNodeInBT = new _4_6_NextNodeInBT();
        BiTreeNode2 root = new BiTreeNode2(15);
        root.lchild = new BiTreeNode2(10);
        root.rchild = new BiTreeNode2(20);
        root.lchild.lchild = new BiTreeNode2(4);
        root.lchild.rchild = new BiTreeNode2(13);
        root.rchild.lchild = new BiTreeNode2(18);
        root.rchild.rchild = new BiTreeNode2(30);
        nextNodeInBT.nonRecursivePreOrder(root);
        System.out.println();
        nextNodeInBT.nonRecursiveInOrder(root);
        System.out.println();
        nextNodeInBT.nonRecursivePostOrder(root);
    }

    // this is practice for binary tree travel +++++ start
    public void nonRecursivePreOrder(BiTreeNode2 root) {
        Stack<BiTreeNode2> stack = new Stack<BiTreeNode2>();
        BiTreeNode2 p = root;
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

    public void nonRecursiveInOrder(BiTreeNode2 root) {
        Stack<BiTreeNode2> stack = new Stack<BiTreeNode2>();
        BiTreeNode2 p = root;

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

    public void nonRecursivePostOrder(BiTreeNode2 root) {
        BiTreeNode2 lastVisit = root;
        BiTreeNode2 p = root;
        Stack<BiTreeNode2> stack = new Stack<BiTreeNode2>();

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
