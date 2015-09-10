package org.buaa.nlp.cj.baseAlgorithm.tree;

import java.util.Stack;

/**
 * Created by Administrator on 2015/8/9.
 */
public class BinaryTree {
    private Node<Integer> root;
    private int size;

    public BinaryTree() {
        root = new Node<Integer>();
    }

    public BinaryTree(Node<Integer> node) {
        this.root = node;
    }

    public Node<Integer> getRoot() {
        return root;
    }

    public void setRoot(Node<Integer> root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 访问节点
     * @param p
     * @return
     */
    public static void visit(Node<Integer> p) {
        System.out.print(p.getValue() + " ");
    }

    /**
     * 递归先序遍历
     * @param p
     */
    public static void preOrder(Node<Integer> p) {
        if (p != null) {
            visit(p);
            preOrder(p.getLchild());
            preOrder(p.getRchild());
        }
    }

    /**
     * 递归中序遍历
     * @param p
     */
    public static void inOrder(Node<Integer> p) {
        if (p != null) {
            inOrder(p.getLchild());
            visit(p);
            inOrder(p.getRchild());
        }
    }

    /**
     * 递归后序遍历
     * @param p
     */
    public static void postOrder(Node<Integer> p) {
        if (p != null) {
            postOrder(p.getLchild());
            postOrder(p.getRchild());
            visit(p);
        }
    }

    /**
     * 非递归前序遍历
     * @param p
     */
    public static void interativePreOrder(Node<Integer> p) {
        Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
        if (p != null) {
            stack.push(p);
            while (!stack.empty()) {
                p = stack.pop();
                visit(p);
                if (p.getLchild() != null)
                    stack.push(p.getRchild());
                if (p.getRchild() != null)
                    stack.push(p.getLchild());
            }
        }
    }

    /**
     * 非递归前序遍历2 *****************************
     * 简单易懂，
     * @param p
     */
    public static void interativePreOrder2(Node<Integer> p) {
        Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
        Node<Integer> node = p;
        while (node != null && stack.size() > 0) {
            // 压入所有的左节点，压入前，先访问
            while (node != null) {
                visit(node);
                stack.push(node);
                node = node.getLchild();
            }

            // 左子树访问完后访问又子树
            if (stack.size() > 0) {
                node = stack.pop();
                node = node.getRchild();
            }
        }
    }

    /**
     * 非递归后序遍历1：单栈法
     * @param node
     */
    public static void interativePostOrder(Node<Integer> node) {
        Node<Integer> p = node;
        Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
        while (node != null) {
            // 左子树入栈
            while (node.getLchild() != null) {
                stack.push(node);
                node = node.getLchild();
            }
            // 当前节点无右子节点或右子节点已经输出
            while (node != null && (node.getRchild() == null || node.getRchild() == p)) {
                visit(node);
                p = node;
                if (stack.empty())
                    return;
                node = stack.pop();
            }
            // 处理右子节点
            stack.push(node);
            node = node.getRchild();
        }
    }

    /**
     * 非递归实现后序遍历2：双栈法
     * @param node
     */
    public static void interativePostOrder2(Node<Integer> node) {
        Stack<Node<Integer>> lstack = new Stack<Node<Integer>>();
        Stack<Node<Integer>> rstack = new Stack<Node<Integer>>();

        Node<Integer> p = node, right;
        do {
            while (p != null) {
                right = p.getRchild();
                lstack.push(p);
                rstack.push(right);
                p = p.getLchild();
            }

            p = lstack.pop();
            right = rstack.pop();
            // 所有右子节点已经全部访问完
            if (right == null) {
                visit(p);
            } else {
                lstack.push(p);
                rstack.push(null);
            }
            p = right;
        } while (lstack.size() > 0 && rstack.size() > 0);
    }

    /**
     * 非递归实现后序遍历3：单栈法
     * @param node
     */
    public static void interativePostOrder3(Node<Integer> node) {
        Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
        Node<Integer> p = node, prev = node;
        while (p != null && stack.size() > 0) {
            while (p != null) {
                stack.push(p);
                p = p.getLchild();
            }
            if (stack.size() > 0) {
                Node<Integer> tmp = stack.peek().getRchild();
                if (tmp == null || tmp == prev) {
                    p = stack.pop();
                    visit(p);
                    prev = p;
                    p = null;
                } else {
                    p = tmp;
                }
            }
        }
    }

    /**
     * 非递归实现后序遍历4：双栈法
     * @param node
     */
    public static void interativePostOrder4(Node<Integer> node) {
        Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
        Stack<Node<Integer>> temp = new Stack<Node<Integer>>();
        Node<Integer> p = node;

        while (p != null && stack.size() > 0) {
            while (p != null) {
                temp.push(p);
                stack.push(p);
                p = p.getRchild();
            }
            if (stack.size() > 0) {
                p = stack.pop();
                p = p.getLchild();
            }
        }

        while (temp.size() > 0) {
            p = temp.pop();
            visit(p);
        }
    }

    /**
     * 非递归实现中序遍历1
     * @param node
     */
    public static void interativeInOrder(Node<Integer> node) {
        Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
        while (node != null) {
            while (node != null) {
                // 当前节点右子节点入栈
                if (node.getRchild() != null)
                    stack.push(node.getRchild());
                // 当前节点入栈
                stack.push(node);
                node = node.getLchild();
            }

            node = stack.pop();
            while (!stack.empty() && node.getRchild() == null) {
                visit(node);
                node = stack.pop();
            }
            visit(node);

            if (!stack.empty())
                node = stack.pop();
            else
                node = null;
        }
    }

    /**
     * 非递归实现中序遍历2 ******************
     * 简单易懂：
     * @param node
     */
    public static void interativeInOrder2(Node<Integer> node) {
        Stack<Node> stack = new Stack<Node>();
        Node p = node;
        while (p != null || stack.size() > 0) {
            while (p != null) {
                stack.push(p);
                p = p.getLchild();
            }
            if (stack.size() > 0) {
                p = stack.pop();
                visit(node);
                node = node.getRchild();
            }
        }
    }

    public static Node<Integer> init() {
        Node<Integer> a = new Node('A');
        Node<Integer> b = new Node('B', null, a);
        Node<Integer> c = new Node('C');
        Node<Integer> d = new Node('D', b, c);
        Node<Integer> e = new Node('E');
        Node<Integer> f = new Node('F', e, null);
        Node<Integer> g = new Node('G', null, f);
        Node<Integer> h = new Node('H', d, g);
        return h;// root
    }

    static class Node<V> {
        private V value;
        private Node<V> lchild;
        private Node<V> rchild;

        public Node() {}

        public Node(V val) {
            this.setValue(val);
            this.setLchild(null);
            this.setRchild(null);
        }

        public Node(V value, Node lchild, Node rchild) {
            this.setValue(value);
            this.setLchild(lchild);
            this.setRchild(rchild);
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<V> getRchild() {
            return rchild;
        }

        public void setRchild(Node<V> rchild) {
            this.rchild = rchild;
        }

        public Node<V> getLchild() {
            return lchild;
        }

        public void setLchild(Node<V> lchild) {
            this.lchild = lchild;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(init());
        System.out.print(" Pre-Order:");
        BinaryTree.inOrder(tree.getRoot());
        System.out.println();

        System.out.print("  In-Order:");
        BinaryTree.inOrder(tree.getRoot());
        System.out.println();

        System.out.print("Post-Order:");
        BinaryTree.postOrder(tree.getRoot());
        System.out.println();

        System.out.print(" Pre-Order:");
        BinaryTree.interativePreOrder(tree.getRoot());
        System.out.println();

        System.out.print("Pre-Order2:");
        BinaryTree.interativePreOrder2(tree.getRoot());
        System.out.println();

        System.out.print("  In-Order:");
        BinaryTree.interativeInOrder(tree.getRoot());
        System.out.println();

        System.out.print(" In-Order2:");
        BinaryTree.interativeInOrder2(tree.getRoot());
        System.out.println();

        System.out.print(" Post-Order:");
        BinaryTree.interativePostOrder(tree.getRoot());
        System.out.println();

        System.out.print("Post-Order2:");
        BinaryTree.interativePostOrder2(tree.getRoot());
        System.out.println();

        System.out.print("Post-Order3:");
        BinaryTree.interativePostOrder3(tree.getRoot());
        System.out.println();

        System.out.print("Post-Order4:");
        BinaryTree.interativePostOrder4(tree.getRoot());
        System.out.println();
    }
}
