package org.buaa.nlp.cj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 * Difficulty: Medium
 Given a collection of numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * Created by Administrator on 2015/10/8.
 */
public class _46_Permutations {
    List<List<Integer>> ser = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0);
//        List<List<Integer>> ser = permute(nums, 0);
//        for (List<Integer> l : ser) {
//            System.out.println(l.toString());
//        }
        return ser;
    }

    public List<List<Integer>> permute(int[] nums, int k) {

        if (k == nums.length-1) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                l.add(nums[i]);
            }
            ser.add(l);
            System.out.println(l.toString());
        } else {
            for (int j = k; j < nums.length; j++) {
                swap(nums, j, k);
                permute(nums, k+1);
                swap(nums, j, k);
            }
        }
        return ser;
    }

    public void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1};
        new _46_Permutations().permute(nums);
    }
}
