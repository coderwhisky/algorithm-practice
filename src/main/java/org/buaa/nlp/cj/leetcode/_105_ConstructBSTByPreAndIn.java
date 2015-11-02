package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/11/3.
 */
public class _105_ConstructBSTByPreAndIn {
    public LeetcodeBiTreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1 || inorder.length < 1)
            return null;
        return buidTreeRecur(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public static LeetcodeBiTreeNode buidTreeRecur(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        int idx = findIdx(inorder, is, ie, preorder[ps]);
        LeetcodeBiTreeNode root = new LeetcodeBiTreeNode(preorder[ps]);
        root.left = buidTreeRecur(preorder, inorder, ps+1, ps+idx-is, is, idx-1);
        root.right = buidTreeRecur(preorder, inorder, ps+idx-is+1, pe, idx+1, ie);
        return root;
    }

    public static int findIdx(int[] nums, int start, int end, int target) {
        int idx = -1;
        for (int i = start; i <= end; i++) {
            if (target == nums[i]) {
                idx = i;
            }
        }
        return idx;
    }
}
