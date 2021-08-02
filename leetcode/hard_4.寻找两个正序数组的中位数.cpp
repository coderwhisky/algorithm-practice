/*
 * @Author: your name
 * @Date: 2021-07-21 23:39:12
 * @LastEditTime: 2021-08-02 23:27:10
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /asr-kaldi-streaming-dev-reconstruct-0608/data1/chenjiang/algorithm-practice/leetcode/hard_4.寻找两个正序数组的中位数.cpp
 */
/*
 * @lc app=leetcode.cn id=4 lang=cpp
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start

#include <iostream>
#include <stdio.h>
#include <vector>

using namespace std;

class Solution {
public:
    int getKthElement(vector<int>& nums1, vector<int>& nums2, int k) {
        int m = nums1.size();
        int n = nums2.size();
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == m) {
                return nums2[index2 + k - 1];
            }
            if (index2 == n) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return min(nums1[index1], nums2[index2]);
            }
            int new_index1 = min(index1 + k/2 - 1, m - 1);
            int new_index2 = min(index2 + k/2 - 1, n - 1);
            int pivot1 = nums1[new_index1];
            int pivot2 = nums2[new_index2];
            if (pivot1 <= pivot2) {
                k -= (new_index1 - index1 + 1);
                index1 = new_index1 + 1;
            } else {
                k -= (new_index2 - index2 + 1);
                index2 = new_index2 + 1;
            }
        }

    }

    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int total_length = nums1.size() + nums2.size();
        if (total_length % 2 == 1) {
            return getKthElement(nums1, nums2, (total_length+1)/2);
        } else {
            return (getKthElement(nums1, nums2, total_length/2) + getKthElement(nums1, nums2, total_length/2+1))/2.0;
        }
    }
};
// @lc code=end

