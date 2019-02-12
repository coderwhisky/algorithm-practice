package org.buaa.nlp.cj.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2015/11/3.
 */
public class _144_BTPreOrder {
    public List<Integer> preorderTraversal(LeetcodeBiTreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<LeetcodeBiTreeNode> stack = new Stack<LeetcodeBiTreeNode>();
        LeetcodeBiTreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                res.add(p.val);
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.right;
            }
        }
        return res;
    }
}
