package org.buaa.nlp.cj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations II
 * Difficulty: Medium
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].
 * Created by Administrator on 2015/10/8.
 */
public class _47_PremutationsUnique {
    List<List<Integer>> ser = new ArrayList<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        permuteUnique(nums, 0);
        for (List<Integer> l : ser) {
            System.out.println(l.toString());
        }
        return ser;
    }

    public void permuteUnique(int[] nums, int k) {
        int len = nums.length;
        if (k == len-1) {
            List<Integer> l = new ArrayList<Integer>();
            for (int i = 0; i < len; i++) {
                l.add(nums[i]);
            }
//            System.out.println(l.toString());
            ser.add(l);
        } else {
            for (int i = k; i < len; i++) {
                if (hasDup(nums, k, i))
                    continue;
                swap(nums, i, k);
                permuteUnique(nums, k+1);
                swap(nums, i, k);
            }
        }
    }

    public void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }

    public boolean hasDup(int[] nums, int s, int e) {
        int i = s;
        while (nums[i] != nums[e] && i < e)
            i++;
        if (i == e) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1,1,2};
        int[] nums = {3,3,0,0,2,3,2};
        new _47_PremutationsUnique().permuteUnique(nums);
    }
}
