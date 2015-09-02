package org.buaa.nlp.cj.nowcoder_BAT_vedio;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Administrator on 2015/9/2.
 */
public class _09_02_2_MaxSubArray {
    public int maxSum(int[] arr) {
        if (arr == null)
            return -999999;
        if (arr.length < 2)
            return arr[0];
        int max = arr[0];
        int cur = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (cur < 0) {
                cur = arr[i];
            }else {
                cur += arr[i];
            }
            max = cur > max ? cur : max;
        }
        return max;
    }
    public int maxSum0(int[] arr) {
        int cur = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                cur = 0;
                for (int k = i; k <= j; k++) {
                    cur += arr[k];
                }
                max = cur > max ? cur : max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        _09_02_2_MaxSubArray maxSubArray = new _09_02_2_MaxSubArray();
        for (int i = 0; i < 1000; i++) {
            int[] arr = new int[10];
            Random random = new Random();
            for (int k = 0; k < 10; k++) {
                arr[k] = random.nextInt(10) -5;
            }
            int max0 = maxSubArray.maxSum0(arr);
            int max1 = maxSubArray.maxSum(arr);
            if (max0 != max1) {
                System.out.println("max0: " + max0);
                System.out.println("max1: " + max1);
                System.out.println(Arrays.toString(arr));
            }
        }
    }
}
