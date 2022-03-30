/*
 * @lc app=leetcode.cn id=72 lang=cpp
 *
 * [72] 编辑距离
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


// @lc code=start
class Solution {
public:
    int minDistance(string word1, string word2) {
        int m = word1.length();
        int n = word2.length();
        vector< vector<int> > edit_dis(m+1, vector<int>(n+1, 0));
        edit_dis[0][0] = 0;
        for (int i = 1; i < m + 1; i++) {
            edit_dis[i][0] = i;
        }
        for (int j = 1; j < n + 1; j++) {
            edit_dis[0][j] = j;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j ++) {
                int left = edit_dis[i][j-1] + 1;
                int up = edit_dis[i-1][j] + 1;
                int up_left = edit_dis[i-1][j-1];
                if (word1[i-1] != word2[j-1]) {
                    up_left = up_left + 1;
                }
                edit_dis[i][j] = min(min(left, up), up_left);
            }
        }
        return edit_dis[m][n];
    }
};
// @lc code=end

