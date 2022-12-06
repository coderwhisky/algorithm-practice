/*
 * @lc app=leetcode.cn id=300 lang=cpp
 *
 * [300] 最长递增子序列
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


// @lc code=start
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int oriLen = nums.size();
        vector<int> max_v(oriLen, 0);
        int max_len = 0;
        for (int i = 0; i < oriLen; i++) {
            max_v[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max_v[i] = max(max_v[j] + 1, max_v[i]);
                } 
            }
            if (max_v[i] > max_len) {
                max_len = max_v[i];
            }
        }
        return max_len;
    }
};
// @lc code=end

