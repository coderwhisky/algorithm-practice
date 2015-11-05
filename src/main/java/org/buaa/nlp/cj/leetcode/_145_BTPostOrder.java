package org.buaa.nlp.cj.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2015/11/3.
 */
public class _145_BTPostOrder {
    public List<Integer> postorderTraversal(LeetcodeBiTreeNode root) {
        List<Integer> ser = new ArrayList<Integer>();
        Stack<LeetcodeBiTreeNode> stack = new Stack<LeetcodeBiTreeNode>();
        LeetcodeBiTreeNode p = root;
        LeetcodeBiTreeNode lastVisit = root;
        while (p != null) {
            while (p.left != null) {
                stack.push(p.left);
                p = p.left;
            }
            while (p != null || (p.right == null || p.right == lastVisit)) {
                ser.add(p.val);
                lastVisit = p;
                if (stack.isEmpty()) {
                    return ser;
                }
                p = stack.pop();
            }
            stack.push(p);
            p = p.right;
        }
        return ser;
    }
}
