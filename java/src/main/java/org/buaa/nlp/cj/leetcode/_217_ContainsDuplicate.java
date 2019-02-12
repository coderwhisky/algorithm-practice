package org.buaa.nlp.cj.leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2015/11/5.
 */
public class _217_ContainsDuplicate {
    // +++++++++++++ method 1 +++++++++++ start
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }
    // +++++++++++++ method 1 +++++++++++ end
}

/*
Contains Duplicate
 Difficulty: Easy
Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array,
 and it should return false if every element is distinct.
 */
