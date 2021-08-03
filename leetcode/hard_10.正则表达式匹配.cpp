/*
 * @Author: your name
 * @Date: 2021-08-03 07:31:50
 * @LastEditTime: 2021-08-03 08:15:57
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/hard_10.正则表达式匹配Please set LastEditors
 */
/*
 * @lc app=leetcode.cn id=10 lang=cpp
 *
 * [10] 正则表达式匹配
 */

#include <iostream>
#include <string>
#include <vector>

using namespace std;

// @lc code=start
class Solution {
public:
    bool matches(const string& s, const string& p, int i, int j ) {
            if (i == 0) {
                return false;
            }
            if (p[j-1] == '.') {
                return true;
            }
            return s[i-1] == p[j-1];
        }

    bool isMatch(string s, string p) {
        int m = s.size();
        int n = p.size();

        vector<vector<int>>  match_res(m+1, vector<int>(n+1));
        match_res[0][0] = true;
        for (int i=0; i <= m; i++) {
            for (int j = 1; j <= n; j++)
            if (p[j-1] == '*') {
                match_res[i][j] |= match_res[i][j-2];
                if (matches(s, p, i, j-1)) {
                    match_res[i][j] |= match_res[i-1][j];
                }
            } else {
                if (matches(s, p, i, j)) {
                    match_res[i][j] |= match_res[i-1][j-1];
                } 
            }
        }
        return match_res[m][n];
    }
};
// @lc code=end

