package org.buaa.nlp.cj.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2015/11/3.
 */
public class _257_BTPath {
    private static List<String> ser = new ArrayList<String>();

    public static List<String> binaryTreePaths(LeetcodeBiTreeNode root) {
        if (root != null) {
            findPaths(root, String.valueOf(root.val));
        }
        return ser;
    }

    public static void findPaths(LeetcodeBiTreeNode root, String path) {
        if (root.left == null && root.right == null) {
            ser.add(path);
        }
        if (root.left == null) {
            findPaths(root.right, path + "->" + root.right.val);
        } else if (root.right == null) {
            findPaths(root.left, path + "->" + root.left.val);
        } else {
            findPaths(root.left, path + "->" + root.left.val);
            findPaths(root.right, path + "->" + root.right.val);
        }
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.length());
        LeetcodeBiTreeNode root = new LeetcodeBiTreeNode(1);
        binaryTreePaths(root);
    }
}
