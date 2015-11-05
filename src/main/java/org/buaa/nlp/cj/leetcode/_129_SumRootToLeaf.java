package org.buaa.nlp.cj.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Administrator on 2015/11/3.
 */
public class _129_SumRootToLeaf {
    public int sumNumbers(LeetcodeBiTreeNode root) {
        if (root == null)
            return 0;
        int sum = 0;
        LinkedList<LeetcodeBiTreeNode> nodeQueue = new LinkedList<LeetcodeBiTreeNode>();
        LinkedList<Integer> sumQueue = new LinkedList<Integer>();
        LeetcodeBiTreeNode p = root;
        nodeQueue.push(root);
        sumQueue.push(root.val);
        while (!nodeQueue.isEmpty()) {
            p = nodeQueue.removeFirst();
            int tmp = sumQueue.removeFirst();
            if (p.left == null && p.right == null) {
                sum += tmp;
            }
            if (p.left != null) {
                nodeQueue.addLast(p.left);
                sumQueue.addLast(tmp*10 + p.left.val);
            }
            if (p.right != null) {
                nodeQueue.addLast(p.right);
                sumQueue.addLast(tmp*10 + p.right.val);
            }
        }
        return sum;
    }
}
