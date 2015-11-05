package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/11/2.
 */
public class _108_SortedArray2BST {
    public LeetcodeBiTreeNode sortedArrayToBST(int[] nums) {
        return convertToBST(nums, 0, nums.length-1);
    }

    public static LeetcodeBiTreeNode convertToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start+end)/2;
        LeetcodeBiTreeNode root = new LeetcodeBiTreeNode(nums[mid]);
        root.left = convertToBST(nums, start, mid-1);
        root.right = convertToBST(nums, mid+1, end);
        return root;
    }
}
