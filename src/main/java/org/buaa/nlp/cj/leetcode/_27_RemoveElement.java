package org.buaa.nlp.cj.leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2015/8/2.
 */
public class _27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int newLen = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == val) {
                continue;
            } else {
                nums[newLen] = nums[i];
                newLen++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return newLen;
    }
    public static void main(String[] args) {
        _27_RemoveElement removeElement = new _27_RemoveElement();
        int[] nums = {2,3,4,2,4,3,1,6};
        int result = removeElement.removeElement(nums, 3);
        System.out.println(result);
    }
}
