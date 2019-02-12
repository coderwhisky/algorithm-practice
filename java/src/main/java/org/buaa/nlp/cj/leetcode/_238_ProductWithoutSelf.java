package org.buaa.nlp.cj.leetcode;

import java.util.Arrays;

/**
 * Created by whisky-yonk on 11/5/2015.
 */
public class _238_ProductWithoutSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] ser = new int[nums.length];
        int product = 1;
        ser[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            product *= nums[i-1];
            ser[i] = product;
        }
        product = 1;
        for (int i = nums.length - 2; i > 0; i--) {
            product *= nums[i+1];
            ser[i] = ser[i] * product;
        }
        product *= nums[1];
        ser[0] = product;
        return ser;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] res = productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
    }
}
/*
Product of Array Except Self
Given an array of n integers where n > 1,
nums, return an array output such that output[i] is equal to
the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity?
(Note: The output array does not count as extra space for the purpose of
 space complexity analysis.)
 */