/*
 * @Author: your name
 * @Date: 2021-07-07 16:03:55
 * @LastEditTime: 2021-07-07 16:22:15
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/easy_1_两数之和_array_adobe.cpp
 */
/*
 * @lc app=leetcode.cn id=1 lang=cpp
 *
 * [1] 两数之和
 */

#include <iostream>
#include <vector>

using namespace std;

// @lc code=start
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        for (int i = 0; i < nums.size(); i++) {
            int to_find = target - nums[i];
            int j = i + 1;
            while (j < nums.size()) {
                if (to_find == nums[j]) {
                    result.push_back(i);
                    result.push_back(j);
                    break;
                } 
                j++;
            }
        }
        for (int i=0; i <result.size(); i ++) {
            cout<< result[i]<< endl;
        }
        return result;
    }
};
// @lc code=end

