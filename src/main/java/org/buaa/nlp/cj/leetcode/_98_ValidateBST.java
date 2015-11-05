package org.buaa.nlp.cj.leetcode;

import java.util.Stack;

/**
 * Created by Administrator on 2015/11/2.
 */
public class _98_ValidateBST {
    public static boolean isValidBST(LeetcodeBiTreeNode root) {
        Stack<LeetcodeBiTreeNode> stack = new Stack<LeetcodeBiTreeNode>();
        LeetcodeBiTreeNode p = root;
//        long min = Integer.MIN_VALUE, mid = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        int pre = Integer.MIN_VALUE, cur = Integer.MIN_VALUE;
        boolean fpre = false, fcur = false;
//        int c = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                if (!fpre) {
                    pre = p.val;
                    fpre = true;
                } else if (!fcur) {
                    cur = p.val;
                    fcur = true;
                } else {
                    pre = cur;
                    cur = p.val;
                }
                if (fcur && pre >= cur)
                    return false;
                p = p.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetcodeBiTreeNode root = new LeetcodeBiTreeNode(0);
        root.left = new LeetcodeBiTreeNode(-1);
        System.out.println(isValidBST(root));
    }
}
