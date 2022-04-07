/*
 * @lc app=leetcode.cn id=279 lang=cpp
 *
 * [279] 完全平方数
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// @lc code=start
class Solution {
public:
    int numSquares(int n) {
        std::vector<int> f(n+1);
        for (int i = 1; i <=n; i++) {
            int tmp_min = INT_MAX;
            for (int j = 1; j*j <= i; j++) {
                tmp_min = std::min(tmp_min, f[i-j*j]);
            }
            f[i] = tmp_min + 1;
        }
        return f[n];
    }
};
// @lc code=end

