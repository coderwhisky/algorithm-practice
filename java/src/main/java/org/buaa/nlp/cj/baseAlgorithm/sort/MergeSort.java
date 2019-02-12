package org.buaa.nlp.cj.baseAlgorithm.sort;

import java.util.Arrays;

/**
 * Created by whisky-yonk on 10/9/2015.
 */
public class MergeSort {
    public static void mergeArray(int[] arr, int first, int mid, int last) {
        int[] tmp = new int[last-first+1];
//        int[] tmp = new int[arr.length];
        int i = first, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= last) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= last) {
            tmp[k++] = arr[j++];
        }

        for (i = 0; i < tmp.length; i++) {
            arr[first+i] = tmp[i];
        }
    }

    public static void mergeSort(int[] arr, int first, int last) {
        if (first < last) {
            int mid = (first+last)/2;
            mergeSort(arr, first, mid);
            mergeSort(arr, mid+1, last);
            mergeArray(arr, first, mid, last);
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,2,5,7,1,10,32,21};
        int[] tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
