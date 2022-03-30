/*
 * @lc app=leetcode.cn id=20 lang=cpp
 *
 * [20] 有效的括号
 */

#include <iostream>
#include <map>
#include <stack>

using namespace std;


// @lc code=start
class Solution {
public:
    bool isValid(string s) {
        map<char, char> valid_pair;
        valid_pair.emplace(std::make_pair(')', '('));
        valid_pair.emplace(std::make_pair(']', '['));
        valid_pair.emplace(std::make_pair('}', '{'));

        stack<char> valid_stack;
        valid_stack.push(s[0]);

        for (int i = 1; i < s.size(); i ++) {
            if (valid_pair.find(s[i]) != valid_pair.end()) {
                if (valid_stack.empty() || valid_stack.top() != valid_pair[s[i]]) {
                    return false;
                }
                valid_stack.pop(); 
            } else {
                valid_stack.push(s[i]);
            }
        }
        return valid_stack.empty();
    }
};

