package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/11/3.
 */
public class _235_LCAofBST {
    public LeetcodeBiTreeNode lowestCommonAncestor(LeetcodeBiTreeNode root, LeetcodeBiTreeNode p, LeetcodeBiTreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (Math.max(p.val, q.val) < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (Math.min(p.val, q.val) > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
