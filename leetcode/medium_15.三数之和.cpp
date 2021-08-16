/*
 * @Author: your name
 * @Date: 2021-08-12 23:27:20
 * @LastEditTime: 2021-08-14 11:49:15
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/medium_15.三数之和.cpp
 */
/*
 * @lc app=leetcode.cn id=15 lang=cpp
 *
 * [15] 三数之和
 */

#include <vector>
#include <iostream>
#include <map>
#include <algorithm>

using namespace std;

// @lc code=start
class Solution {
public:
    vector< vector<int> > threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector< vector<int> >  three_sum_idx;
        for (int first = 0; first < nums.size(); first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = -nums[first];
            int third = nums.size() - 1;
            for (int second = first + 1; second < nums.size(); second++) {
                if (second > first + 1 && nums[second] == nums[second-1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    three_sum_idx.push_back({nums[first], nums[second], nums[third]});
                }
            }
        }
        return three_sum_idx;
    }
};
// @lc code=end

