/*
 * @Author: your name
 * @Date: 2021-08-18 22:42:11
 * @LastEditTime: 2021-08-18 22:51:57
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/medium_322.零钱兑换.cpp
 */
/*
 * @lc app=leetcode.cn id=322 lang=cpp
 *
 * [322] 零钱兑换
 */

#include <vector>
#include <algorithm>


// @lc code=start
class Solution {
public:
    int coinChange(std::vector<int>& coins, int amount) {
        std::vector<int> dp(amount + 1, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.size(); j++) {
                if (i - coins[j] < 0) {
                    continue;
                }
                dp[i] = std::min(dp[i-coins[j]] + 1, dp[i]);
            }
        }
        if (dp[amount] <= amount) {
            return dp[amount];
        } else {
            return -1;
        }
    }
};
// @lc code=end

