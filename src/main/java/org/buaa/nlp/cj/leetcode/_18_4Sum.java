package org.buaa.nlp.cj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2015/7/27.
 */
public class _18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums == null || nums.length < 4)
            return result;

        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
//                int tmpTarget = target - nums[i] - nums[j];
                int l = j+1;
                int r = nums.length - 1;
                while (l < r) {
                    List<Integer> tmplist = new ArrayList<Integer>();
                    int tmpSum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (tmpSum == target) {
                        tmplist.add(nums[i]);
                        tmplist.add(nums[j]);
                        tmplist.add(nums[l]);
                        tmplist.add(nums[r]);
                        if (!result.contains(tmplist)) {
                            result.add(tmplist);
                        }
                        l++;
                        r--;
                    } else if (tmpSum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return result;
    }

    public void quickSort(int[] nums, int left, int right) {
        int low = left;
        int high = right;
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] > pivot) high--;
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) low++;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        if (left < low)
            quickSort(nums, left, low -1);
        if (high < right)
            quickSort(nums, low+1, right);
    }

    public static void main(String[] args) {
        _18_4Sum _4sum = new _18_4Sum();
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        List<List<Integer>> result = _4sum.fourSum(nums, 0);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString());
        }
    }
}
