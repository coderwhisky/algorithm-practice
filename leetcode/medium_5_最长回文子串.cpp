/*
 * @Author: your name
 * @Date: 2021-11-19 08:44:13
 * @LastEditTime: 2021-11-24 08:40:27
 * @LastEditors: Please set LastEditors
 * @lc app=leetcode.cn id=5 lang=cpp
 *
 * [5] 最长回文子串
 */


#include <iostream>
#include <string>
#include <vector>

using namespace std;

// @lc code=start
class Solution {
public:
    string longestPalindrome(string s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        vector< vector<int> > dp(length, vector<int>(length));
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        int maxLen = 1;
        int beginIdx = 0;
        for (int l = 2; l <= length; l++) {
            for (int i = 0; i < length; i++) {
                int j = i + l - 1;
                if (j >= length) {
                    break;
                }
                if (s[i] == s[j]) {
                    if (j-i < 3) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                } else {
                    dp[i][j] = 0;
                }

                if (dp[i][j] == 1 && j-i+1 > maxLen) {
                    beginIdx = i;
                    maxLen = j-i+1;
                }
            }
        }
        return s.substr(beginIdx, maxLen);
    }
};
// @lc code=end

