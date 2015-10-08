package org.buaa.nlp.cj.leetcode;

import java.util.Arrays;

/**
 * Next Permutation  Difficulty: Medium
 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1

 * Created by Administrator on 2015/10/8.
 */
public class _31_NextPermutation {
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void nextPermutation(int[] nums) {
        int len = nums.length;
//        int i = len-1;
        for (int i = len-1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                int j = len-1;
                for (; j > i-1; j--)
                    if (nums[j] > nums[i-1])
                        break;
                int tmp = nums[i-1];
                nums[i-1] = nums[j];
                nums[j] = tmp;
                reverse(nums, i, len-1);
                return;
            }
        }
        reverse(nums, 0, len-1);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,5};
//        reverse(nums, 0, 4);
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
