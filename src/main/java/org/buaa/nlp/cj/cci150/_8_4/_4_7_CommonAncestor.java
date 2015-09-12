package org.buaa.nlp.cj.cci150._8_4;

/**
 * 设计一个算法，找出二叉树中某两个结点的第一个共同祖先。
 * 不得将额外的结点存储在另外的数据结构中。注意，这不一定是二叉查找树
 * Created by whisky-yonk on 9/12/2015.
 */
public class _4_7_CommonAncestor {

    // ************** method 1 ******* start
    public boolean covers(BiTreeNode root, BiTreeNode node) {
        if (root == null)
            return false;
        if (root == node)
            return true;
        return covers(root.lchild, node) || covers(root.rchild, node);
    }

    public BiTreeNode commonAncestor(BiTreeNode root, BiTreeNode p, BiTreeNode q) {
        if (root == null || !covers(root, p) || !covers(root, q))
            return null;
        if (root == p || root == q)
            return root;

        boolean is_p_on_left = covers(root.lchild, p);
        boolean is_q_on_left = covers(root.lchild, q);

        // p and q is not on the same side from root
        if (is_p_on_left != is_q_on_left)
            return root;

        // otherwise, p and q is on the same side, recursively travel the side(left or right)
        BiTreeNode childSide = is_p_on_left ? root.lchild : root.rchild;

        return commonAncestor(childSide, p, q);
    }
    // ************** method 1 ******* end

    // ================== method 2 ============ start

    // ================== method 2 ============ end

    public static void main(String[] args) {
        BiTreeNode root = new BiTreeNode(15);
        root.lchild = new BiTreeNode(10);
        root.rchild = new BiTreeNode(20);
        BiTreeNode p = new BiTreeNode(4);
        root.lchild.lchild = p;
        BiTreeNode q = new BiTreeNode(13);
        root.lchild.rchild = q;
        root.rchild.lchild = new BiTreeNode(18);
        BiTreeNode r = new BiTreeNode(30);
        root.rchild.rchild = r;

        _4_7_CommonAncestor commonAncestor = new _4_7_CommonAncestor();
        BiTreeNode common = commonAncestor.commonAncestor(root, p, r);
        System.out.println(common.val);
    }
}
