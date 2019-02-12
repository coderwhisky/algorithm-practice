package org.buaa.nlp.cj.jobOnlineProgram.wenwen;

/**
 * 计算一个有序数组中给定数 k 出现的次数，要求时间复杂度为 O(logn)
 * Created by Administrator on 2015/11/3.
 */
public class CountInSortedArray {
    public int countItem(int[] nums, int k) {
        int left = findIdx(nums, 0, nums.length-1, k, true);
        int right = findIdx(nums, 0, nums.length-1, k, false);
        if (left == -1 && right == -1) {
            return 0;
        } else {
            return left-right+1;
        }
    }

    public int biSearch(int[] nums, int start, int end, int k) {
        while (start <= end) {
            int mid = (start+end)/2;
            if (k < nums[mid]) {
                end = mid - 1;
            } else if (k > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static int findIdx(int[] nums, int p, int q, int k, boolean firstFlag) {
        int start = p, end = q;
        while (start <= end) {
            int mid = (start+end)/2;
            if (nums[mid] == k) {
                // most left;
                if (firstFlag) {
                    if (mid != p && nums[mid-1] != k)
                        return mid;
                    else if (mid == p)
                        return p;
                    else
                        end = mid-1;
                }else {
                    // most right
                    if (mid != q && nums[mid+1] != k)
                        return mid;
                    else if (mid == q) {
                        return mid;
                    } else {
                        start = mid+1;
                    }
                }
            } else if (k < nums[mid]) {
                end = mid - 1;
            } else {
                end = mid + 1;
            }
        }
        return -1;
    }
}
