package org.buaa.nlp.cj.leetcode;

/**
 * Created by whisky-yonk on 11/5/2015.
 */
public class _268_MissingNumber {
    // ================== method 1 ====== start
    public int missingNumber(int[] nums) {
        int ser = -1;
        boolean[] flag = new boolean[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            flag[nums[i]] = true;
        }
        for (int i = 0; i < flag.length; i++) {
            if (!flag[i]){
                ser = i;
                break;
            }
        }
        return ser;
    }
    // ================== method 1 ====== end

    // ================== method 2 ====== start
    public int missingNumber2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        int expect = nums.length * (nums.length+1)/2;
        return expect - sum;
    }
    // ================== method 2 ====== end
}
/*
Missing Number My Submissions Question
Difficulty: Medium
Given an array containing n distinct numbers taken from
 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.
 */