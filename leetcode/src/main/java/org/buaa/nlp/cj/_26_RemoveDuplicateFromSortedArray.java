package org.buaa.nlp.cj;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2015/8/2.
 */
public class _26_RemoveDuplicateFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int newLen = 1;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] == nums[i-1]) {
                i++;
                continue;
            } else {
                nums[newLen] = nums[i];
                newLen++;
                i++;
            }
        }
//        System.out.println(Arrays.toString(nums));
        return newLen;
    }
    public static void main(String[] args) {
        _26_RemoveDuplicateFromSortedArray removeDuplicateFromSortedArray = new _26_RemoveDuplicateFromSortedArray();
        int[] nums = {1,1,2};
        int result = removeDuplicateFromSortedArray.removeDuplicates(nums);
        System.out.println(result);
    }
}
