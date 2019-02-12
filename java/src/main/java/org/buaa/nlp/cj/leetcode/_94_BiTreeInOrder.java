package org.buaa.nlp.cj.leetcode;

import org.buaa.nlp.cj.Utils.BiTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2015/11/2.
 */
public class _94_BiTreeInOrder {
    public List<Integer> inorderTraversal(LeetcodeBiTreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<LeetcodeBiTreeNode> stack = new Stack<LeetcodeBiTreeNode>();
        LeetcodeBiTreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                res.add(p.val);
                p = p.right;
            }
        }
        return res;
    }
}
