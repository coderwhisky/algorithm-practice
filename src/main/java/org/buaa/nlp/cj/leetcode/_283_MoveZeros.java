package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/11/4.
 */
public class _283_MoveZeros {
    public void moveZeroes(int[] nums) {
        int k = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[k++] = nums[i++];
            } else {
                i++;
            }
        }
        while (k < nums.length) {
            nums[k++] = 0;
        }
    }
}
