/*
 * @lc app=leetcode.cn id=673 lang=cpp
 *
 * [673] 最长递增子序列的个数
 */

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


// @lc code=start
class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) {
        int len = nums.size();
        vector<int> dp(len, 0);
        vector<int> cnt(len, 0);
        int max_len = 0;
        int ans = 0;
        for(int i = 0; i < len; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = max(dp[i], dp[j] + 1);
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > max_len) {
                max_len = dp[i];
                ans = cnt[i];
            } else if (dp[i] == max_len) {
                ans += cnt[i];
            } 
        }
        return ans;
    }
};
// @lc code=end

