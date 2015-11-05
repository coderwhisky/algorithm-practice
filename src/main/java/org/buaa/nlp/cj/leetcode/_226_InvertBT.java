package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/11/3.
 */
public class _226_InvertBT {
    public LeetcodeBiTreeNode invertTree(LeetcodeBiTreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return root;
        LeetcodeBiTreeNode left = null, right = null;
        if (root.left != null) {
            left = invertTree(root.left);
        }
        if (root.right != null) {
            right = invertTree(root.right);
        }
        root.left = right;
        root.right = left;
        return root;
    }
}
