package org.buaa.nlp.cj.cci150._8_4;

import org.buaa.nlp.cj.Utils.BiTreeNode;

/**
 * Created by whisky-yonk on 8/31/2015.
 */
public class _4_1_IsBalance {

    // ============ 方法一：start
    public static int getHeight(BiTreeNode root) {
        if (root == null)
            return 0;
        return Math.max(getHeight(root.lchild), getHeight(root.rchild)) + 1;
    }

    public static boolean isBalanced(BiTreeNode root) {
        if (root == null)
            return true;

        int heightDiff = Math.abs(getHeight(root.lchild) - getHeight(root.rchild));
        if (heightDiff > 1)
            return false;
        else
            return isBalanced(root.lchild) && isBalanced(root.rchild);
    }
    // ============方法一：end

    // ============ method 2: start

    /**
     * 检查子树的高度，如果子树是平衡的则返回子树的高度，如果是不平衡的，则直接返回-1
     * @param root
     * @return
     */
    public static int checkHeight(BiTreeNode root) {
        if (root == null)
            return 0;

        // check if left biTree is balanced
        int leftHeight = checkHeight(root.lchild);
        if (leftHeight == -1)
            return -1;
        // check if right biTree is balanced
        int rightHeight = checkHeight(root.rchild);
        if (rightHeight == -1)
            return -1;
        // check if this node is balanced
        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1)
            return -1;
        else
            return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean isBalanced2(BiTreeNode root) {
        if (checkHeight(root) == -1) {
            return false;
        } else {
            return true;
        }
    }
    // ============ method 2: end


    public static void main(String[] args) {
        _4_1_IsBalance isBalance = new _4_1_IsBalance();
    }
}
