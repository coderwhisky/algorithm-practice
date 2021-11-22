/*
 * @lc app=leetcode.cn id=20 lang=cpp
 *
 * [20] 有效的括号
 */


#include <iostream>
#include <stack>
#include <unordered_map>

using namespace std;

// @lc code=start
class Solution {
public:
    bool isValid(string s) {
        if (s.size() % 2 == 1 ) {
            return false;
        }
        
        unordered_map<char, char> pairs = { 
            {')', '('},
            {'}', '{'},
            {']', '['}
        };
        stack<char> cstk;
        for (char ch : s) {
            if (pairs.count(ch)) {
                if (cstk.empty() || cstk.top() != pairs[ch]) {
                    return false;
                }
                cstk.pop();
            } else {
                cstk.push(ch);
            }
        }
        return cstk.empty();
    }
};
// @lc code=end

