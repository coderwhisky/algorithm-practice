/*
 * @Author: your name
 * @Date: 2021-08-05 07:54:04
 * @LastEditTime: 2021-08-05 08:28:04
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/medium_300.最长递增子序列.cpp
 */
/*
 * @lc app=leetcode.cn id=300 lang=cpp
 *
 * [300] 最长递增子序列
 */

#include <iostream>
#include <vector>

using namespace std;

// @lc code=start
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        if (n == 0) {
            return 0;
        } 

        vector<int> dp(n, 0);
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = max(dp[i], dp[j]+1);
                }
            }
        }
        int max_len = 0;
        for (int i = 0; i < dp.size(); i++){
            if (dp[i] > max_len) {
                max_len = dp[i];
            }
        } 
        return max_len;
    }
};
// @lc code=end

