package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/7/4.
 */
public class _4_MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        if ((total & 1) == 1) {
            return findKth(nums1, m, 0, nums2, n, 0, total/2 + 1);
        }else
            return (findKth(nums1, m, 0, nums2, n, 0, total/2) + findKth(nums1, m, 0, nums2, n, 0, total/2 + 1))/2;
    }

    public double findKth(int a[], int m, int startA, int b[], int n, int startB, int k ) {
        if (m > n)
            return findKth(b, n, startB, a, m, startA, k);
        if (m == 0)
            return b[startB+k-1];
        if (k == 1)
            return a[startA] > b[startB] ? b[startB] : a[startA];
        int pa = (k/2) < m ? (k/2) : m;
        int pb = k - pa;
        if (a[startA + pa - 1] < b[startB + pb - 1])
            return findKth(a, m-pa, startA+pa, b, n, startB, k-pa);
        else
            return findKth(a, m, startA, b, n-pb, startB+pb, k-pb);
    }

    public static void main(String[] args) {
        _4_MedianOfTwoSortedArray _4MedianOfTwoSortedArray = new _4_MedianOfTwoSortedArray();
        int nums1[] = {};
        int nums2[] = {1};
        _4MedianOfTwoSortedArray.findMedianSortedArrays(nums2, nums1);
    }
}
