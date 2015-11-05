package org.buaa.nlp.cj.leetcode;

import java.util.Stack;

/**
 * Created by Administrator on 2015/11/3.
 */
public class _230_KthSmallestInBST {
    public int kthSmallest(LeetcodeBiTreeNode root, int k) {
        LeetcodeBiTreeNode p = root;
        Stack<LeetcodeBiTreeNode> stack = new Stack<LeetcodeBiTreeNode>();
        int c = 0, ser = -1;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                c++;
                if (c == k) {
                    ser = p.val;
                }
                p = p.right;
            }
        }
        return ser;
    }
}
