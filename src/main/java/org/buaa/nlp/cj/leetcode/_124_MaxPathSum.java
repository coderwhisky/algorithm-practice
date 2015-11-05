package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/11/3.
 */
public class _124_MaxPathSum {
    public int maxPathSum(LeetcodeBiTreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null)
            return root.val;
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        postOrder(root, res);
        return res[0];
    }

    public static int postOrder(LeetcodeBiTreeNode root, int[] res) {
        int left = 0, right = 0;
//        if (root == null)
//            return 0;
        if (root.left != null) {
            left = postOrder(root.left, res);
        }
        if (root.right != null) {
            right = postOrder(root.right, res);
        }
        int res_this = Math.max(Math.max(left+root.val, right+root.val), root.val);
        int tmp = Math.max(res_this, left + right + root.val);
        if (tmp > res[0])
            res[0] = tmp;
        return res_this;
    }
}
