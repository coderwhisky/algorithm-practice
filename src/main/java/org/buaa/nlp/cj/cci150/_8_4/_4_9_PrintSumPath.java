package org.buaa.nlp.cj.cci150._8_4;

import org.buaa.nlp.cj.Utils.BiTreeNode;

/**
 * 给定一棵二叉树，其中每个节点都含有一个数值。设计一个算法，打印节点数值总和等于某个给定值的所有路径。
 * 注意：路径不一定非得从二叉树的根节点或者叶节点开始或结束
 * Created by whisky-yonk on 9/12/2015.
 */
public class _4_9_PrintSumPath {

    public void findSum(BiTreeNode node, int sum, int[] path, int level) {
        if (node == null)
            return;

        // insert the current node into path
        path[level] = node.val;

        // find the path ended with this node and summed up to sum
        int t = 0;
        for (int i = level; i >= 0; i--) {
            t += path[i];
            if (t == sum)
                print(path, i, level);
        }

        // find sum in sub tree of this node
        findSum(node.lchild, sum, path, level+1);
        findSum(node.rchild, sum, path, level+1);

        // I feel something wrong with this
        path[level] = Integer.MIN_VALUE;
    }

    public void findSum(BiTreeNode node, int sum) {
        int depth = depth(node);
        int[] path = new int[depth];
        findSum(node, sum, path, 0);
    }

    public void print(int[] path, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }

    public int depth(BiTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(depth(node.lchild), depth(node.rchild));
        }
    }
    public static void main(String[] args) {
        _4_9_PrintSumPath printSumPath = new _4_9_PrintSumPath();

        BiTreeNode root = new BiTreeNode(15);
        root.lchild = new BiTreeNode(13);
        root.rchild = new BiTreeNode(4);
        root.lchild.lchild = new BiTreeNode(10);
        root.lchild.lchild.lchild = new BiTreeNode(-1);
        root.lchild.lchild.rchild = new BiTreeNode(13);
        root.lchild.rchild = new BiTreeNode(13);
        root.lchild.rchild.lchild = new BiTreeNode(4);
        root.lchild.rchild.rchild = new BiTreeNode(10);
        root.rchild.lchild = new BiTreeNode(18);
        root.rchild.rchild = new BiTreeNode(4);
        root.rchild.rchild.lchild = new BiTreeNode(7);
        root.rchild.rchild.lchild.lchild = new BiTreeNode(8);

        printSumPath.findSum(root, 23);
    }
}
