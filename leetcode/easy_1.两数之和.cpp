/*
 * @Author: your name
 * @Date: 2021-08-12 22:50:57
 * @LastEditTime: 2021-08-12 23:13:20
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/easy_1.两数之和.cpp
 */
/*
 * @lc app=leetcode.cn id=1 lang=cpp
 *
 * [1] 两数之和
 */

#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>
#include <map>

using namespace std;

// @lc code=start

// class Solution1 {
// public:
//     vector<int> twoSum(vector<int>& nums, int target) {
//         int n = nums.size();
//         vector<int> two_sum_idx;
//         for (int i = 0; i < n; i ++) {
//             int to_find = target - nums[i];
//             for (int j = i + 1; j < n; j ++) {
//                 if (to_find == nums[j]) {
//                     two_sum_idx.push_back(i);
//                     two_sum_idx.push_back(j);
//                 }
//             }
//         }
//         return two_sum_idx;
//     }
// };

class Solution {
public:
    std::vector<int> twoSum(std::vector<int>& nums, int target) {
        int n = nums.size();
        std::vector<int> two_sum_idx;
        std::map<int, int> value_idx;
        // for (int i = 0; i < nums.size(); i++) {
        //     value_idx.insert(make_pair(nums[i], i));
        // }
        for (int i=0; i < nums.size(); i++) {
            int to_find = target - nums[i];
            auto searched = value_idx.find(to_find);
            if (searched != value_idx.end()) {
                if (i != searched->second) {
                    two_sum_idx.push_back(i);
                    two_sum_idx.push_back(searched->second);
                    break;
                } 
            }
            value_idx.insert(make_pair(nums[i], i));
        }
        return two_sum_idx;
    }
};
// @lc code=end

