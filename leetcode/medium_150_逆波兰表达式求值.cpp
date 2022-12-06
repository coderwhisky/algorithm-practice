
/*
 * @lc app=leetcode.cn id=150 lang=cpp
 *
 * [150] 逆波兰表达式求值
 */

#include <iostream>
#include <vector>
#include <stack>

using namespace std;

// @lc code=start
class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> sum_stack;
        for (int i = 0; i < tokens.size(); i++) {
            std::string& token = tokens[i];
            if (token != "+" && token != "-" && token != "*" and token != "/") {
                sum_stack.push(stoi(token));
            } else {
                int top1 = sum_stack.top();
                sum_stack.pop();
                int top2 = sum_stack.top();
                sum_stack.pop();
                switch (token[0]) {
                    case '+':
                        sum_stack.push(top1 + top2);
                        break;
                    case '-':
                        sum_stack.push(top2 - top1);
                        break;
                    case '*':
                        sum_stack.push(top1 * top2);
                        break;
                    case '/':
                        sum_stack.push(top2 / top1);
                        break;
                    default:
                        sum_stack.push(stod(tokens[i]));
                        break;
                }
            }

        }
        return sum_stack.top();
    }
};
// @lc code=end

