package org.buaa.nlp.cj.cci150;

/**
 * 题目描述：
 * 一个有序数组的元素经过循环移动，元素的循序发生变化，如变成 3 4 5 6 1 2
 * 怎样才能找出其中最小的元素，假设数组中的元素各不相同。
 * Created by whisky-yonk on 8/24/2015.
 */
public class _6_5_FindMinInPartialSortedArray {
    int findMin(int[] array, int left, int right) {
        if (left == right) {
            return array[left];
        }
        if (left > right) {
            return findMin(array, right, left);
        }
        int mid = left + (right - left) / 2;
        if (mid == left || mid == right) {
            return array[mid];
        }
        if (array[mid] > array[mid - 1] && array[mid] < array[mid+1])
            return array[mid];

        if (array[mid] < array[right] ) {
            if (array[left] < array[mid])
                return array[left];
            findMin(array, left, mid);
        } else if (array[mid] > array[right]) {
            findMin(array, mid, right);
        } else {
            return array[mid];
        }
        return array[mid];
    }


    public static void main(String[] args) {
        _6_5_FindMinInPartialSortedArray findMinInPartialSortedArray = new _6_5_FindMinInPartialSortedArray();
        int[] array = {3,4,5,6,7,1,2};
        int result = findMinInPartialSortedArray.findMin(array, 0, 6);
        System.out.println(result);
    }
}
