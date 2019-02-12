package org.buaa.nlp.cj.codingInterviewGuide._2015_09_02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 题目五

 给定一个无序数组arr，其中元素可正、可负、可0，再给定一个整数k，求arr所有的子数组中累加和为k的最长子数组长度。
 * Created by Administrator on 2015/9/2.
 */
public class _05_MaxSubArrayOfKSum {
    public int maxKSum0(int[] arr, int k) {
        if (arr.length < 1)
            return -1;
        if (arr.length < 2 && arr[0] != k)
            return -1;

        int sum = 0;
        int maxlen = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum = 0;
                for (int kk = i; kk <= j; kk++) {
                    sum += arr[kk];
                }
                if (sum == k) {
                    maxlen = (j - i +1) > maxlen ? (j - i + 1) : maxlen;
                }
            }
        }
        return maxlen;
    }

    public int maxKSum(int[] arr, int k) {
        if (arr.length < 1)
            return -1;
        if (arr.length < 2 && arr[0] != k)
            return -1;

        Map<Integer, Integer> help = new HashMap<Integer, Integer>();
        help.put(0,-1);

        int sum = 0;
        int maxlen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (help.containsKey(sum - k)) {
                maxlen = maxlen > (i - help.get(sum - k)) ? maxlen : (i - help.get(sum - k));
            }
            if (!help.containsKey(sum)) {
                help.put(sum, i);
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        _05_MaxSubArrayOfKSum maxSubArrayOfKSum = new _05_MaxSubArrayOfKSum();
        for (int i = 0; i < 1000; i++) {
            int[] arr = new int[10];
            Random random = new Random();
            for (int k = 0; k < 10; k++) {
                arr[k] = random.nextInt(10) -5;
            }
            int k = random.nextInt(10);
            int max0 = maxSubArrayOfKSum.maxKSum0(arr, k);
            int max1 = maxSubArrayOfKSum.maxKSum(arr, k);
            if (max0 != max1) {
                System.out.println("max0: " + max0);
                System.out.println("max1: " + max1);
                System.out.println(Arrays.toString(arr));
            }
        }

        int[] arr0 = {1,1,1,2,-2,-1};
        int k0 = 3;
        int max0 = maxSubArrayOfKSum.maxKSum0(arr0, k0);
        int max1 = maxSubArrayOfKSum.maxKSum(arr0, k0);
    }
}
