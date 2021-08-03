/*
 * @Author: your name
 * @Date: 2021-08-03 23:36:29
 * @LastEditTime: 2021-08-03 23:41:17
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /asr-kaldi-streaming-dev-reconstruct-0608/data1/chenjiang/algorithm-practice/leetcode/hard_32.最长有效括号.cpp
 */
/*
 * @lc app=leetcode.cn id=32 lang=cpp
 *
 * [32] 最长有效括号
 */

#include <iostream>
#include <string>
#include <stack>

using namespace std;

// @lc code=start
class Solution {
public:
    int longestValidParentheses(string s) {
        stack<int> ss;
        ss.push(-1);
        int max_len = 0;
        int i = 0;
        // while (i < s.size()) {
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                ss.push(i);
                // i += 1;
            } else {
                ss.pop();
                if (ss.empty()) {
                    ss.push(i);
                    // i += 1;
                } else {
                    if (max_len < i - ss.top()) {
                        max_len = i - ss.top();
                    }
                }
            }
        }
        return max_len;
    }
};
// @lc code=end

