package org.buaa.nlp.cj.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Administrator on 2015/11/5.
 */
public class _220_ContainsDuplicate3 {
    // ================= method 1 ===================== start
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 1 || t < 0)
            return false;
        SortedSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            SortedSet<Long> subset = set.subSet((long) nums[i]-t, (long) nums[i]+t+1);
            if (!subset.isEmpty())
                return true;
            if (i >= k) {
                set.remove((long) nums[i-k]);
            }
            set.add((long) nums[i]);
        }
        return false;
    }
    // ================= method 1 ===================== end
}

/*
Contains Duplicate III
 Difficulty: Medium
Given an array of integers, find out whether there are two distinct indices i and j in the array
 such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 */