package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/10/8.
 */
public class _60_PermutationSequence {
    public static String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i-1] = i;
        }
        for (int i = 1; i < k; i++) {
            nextPermutation(nums);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void nextPermutation(int[] nums) {
        int len = nums.length;
//        int i = len-1;
        for (int i = len-1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                int j = len-1;
                for (; j > i-1; j--)
                    if (nums[j] > nums[i-1])
                        break;
                int tmp = nums[i-1];
                nums[i-1] = nums[j];
                nums[j] = tmp;
                reverse(nums, i, len-1);
                return;
            }
        }
        reverse(nums, 0, len-1);
    }

    public static void main(String[] args) {
        String ser = getPermutation(3, 3);
        System.out.println(ser);
    }

}
