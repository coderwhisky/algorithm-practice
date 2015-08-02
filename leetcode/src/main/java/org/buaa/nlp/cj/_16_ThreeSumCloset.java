package org.buaa.nlp.cj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by whisky on 2015/7/16.
 */
public class _16_ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        quicksort(nums, 0, len-1);
        System.out.println(Arrays.toString(nums));

        int minDif = Integer.MAX_VALUE;
        int val = 0;
        for (int i = 0; i < len; i++) {
            int low = i+1;
            int high = len-1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(target - sum) < minDif) {
                    minDif = Math.abs(target - sum);
                    val = sum;
                }
                if (val == target) {
                    return val;
                } else if (target > sum) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return val;
    }

    public void quicksort(int[] nums, int left, int right) {
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
//        System.out.println(Arrays.toString(nums));
        if (low > left)
            quicksort(nums, left, low-1);
        if (high < right)
            quicksort(nums, low+1, right);
    }

    public static void main(String[] args) {
        _16_ThreeSumCloset threeSumCloset = new _16_ThreeSumCloset();
        int[] nums = {65,2,667,34,90,21,3};
        int result = threeSumCloset.threeSumClosest(nums, 50);
        System.out.println(result);
    }
}
