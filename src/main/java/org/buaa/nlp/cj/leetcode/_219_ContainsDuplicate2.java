package org.buaa.nlp.cj.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/11/5.
 */
public class _219_ContainsDuplicate2 {
    // ====================== method 1 ============ start
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 1 || k < 1)
            return false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int tt = map.get(nums[i]);
                if (i - tt <= k) {
                    return true;
                }
                map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
    // ====================== method 1 ============ end
}

/*
Contains Duplicate II
Difficulty: Easy
Given an array of integers and an integer k,
find out whether there are two distinct indices i and j in the array such that
nums[i] = nums[j] and the difference between i and j is at most k.
 */