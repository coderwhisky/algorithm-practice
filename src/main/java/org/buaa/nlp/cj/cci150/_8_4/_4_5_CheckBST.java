package org.buaa.nlp.cj.cci150._8_4;

/**
 * 检查一颗二叉树是否是一颗二叉查找树
 * Created by Administrator on 2015/9/11.
 */
public class _4_5_CheckBST {
    // ============== method 1 start: ==========

    /**
     * 评价：此算法是有问题的，因为无法正确判别如下类别的树：, so, this is a wrong method
     *             20
     *          -      -
     *        10        30
     *          -25
     * @param node
     * @return
     */
    public boolean checkBST(BiTreeNode node) {
        int last_printed = Integer.MIN_VALUE;
        if (node == null)
            return true;

        if (!checkBST(node.lchild))
            return false;

        if (node.val <= last_printed)
            return false;
        last_printed = node.val;

        if (!checkBST(node.rchild))
            return false;

        return true;
    }
    // ============== method 1 end: ==========

    // **************** method 2 start: *************
    public boolean checkBST2(BiTreeNode node, int min, int max) {
        if (node == null)
            return true;

        // 此处 < 和 >= 的选择时因为二叉查找树的定义为：左子树小于当前节点，右子树大于等于当前节点
        if (node.val < min || node.val >= max) {
            return false;
        }

        if (!checkBST2(node.lchild, min, node.val) ||
                !checkBST2(node.rchild, node.val, max)) {
            return false;
        }

        return true;
    }

    public boolean checkBST2(BiTreeNode root) {
        return checkBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // **************** method 2 end: *************

    public static void main(String[] args) {
        _4_5_CheckBST checkBST = new _4_5_CheckBST();
        BiTreeNode root = new BiTreeNode(20);
        root.lchild = new BiTreeNode(15);
        root.rchild = new BiTreeNode(30);
        root.lchild.lchild = new BiTreeNode(14);
        root.lchild.rchild = new BiTreeNode(21);
        boolean result = checkBST.checkBST2(root);
        System.out.println(result);
    }
}
