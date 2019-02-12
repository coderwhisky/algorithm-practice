package org.buaa.nlp.cj.leetcode;

import java.util.Stack;

/**
 * Created by Administrator on 2015/11/2.
 */
public class _99_RecoverBST {
    public static void recoverTree(LeetcodeBiTreeNode root) {
        LeetcodeBiTreeNode p = root;
        Stack<LeetcodeBiTreeNode> stack = new Stack<LeetcodeBiTreeNode>();
//        boolean fpre = false, fcur = false;
        LeetcodeBiTreeNode pre = null, first = null, second = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                if (pre == null) {
                    pre = p;
                } else if (first == null) {
                    first = p;
                } else if (second == null){
                    second = p;
                } else {
                    pre = first;
                    first = second;
                    second = p;
                }
                if (second != null && first.val > second.val) {
                    int tmp = first.val;
                    first.val = second.val;
                    second.val = tmp;
                }
//                else if (first != null){
//                    if (pre.val > first.val) {
//                        int tmp = pre.val;
//                        pre.val = first.val;
//                        first.val = tmp;
//                    }
//                }
                p = p.right;
            }
        }
    }

    public static void main(String[] args) {
        LeetcodeBiTreeNode root = new LeetcodeBiTreeNode(2);
        root.left = new LeetcodeBiTreeNode(3);
        root.right = new LeetcodeBiTreeNode(1);
        recoverTree(root);
    }
}
