
/*
 * @lc app=leetcode.cn id=64 lang=cpp
 *
 * [64] 最小路径和
 */

#include <iostream>
#include <stdio.h>
#include <algorithm>

using namespace std;

// @lc code=start
class Solution {
public:
    int minPathSum(std::vector<std::vector<int> >& grid) {
        if ( grid.size() == 0 || grid[0].size() == 0) {
            return 0;
        }
        int rows = grid.size(), cols = grid[0].size();
        std::vector<std::vector<int> > dp(rows, std::vector<int>(cols));
        dp[0][0] = grid[0][0];
        
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = std::min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[rows -1][cols-1];
    }
};
// @lc code=end

