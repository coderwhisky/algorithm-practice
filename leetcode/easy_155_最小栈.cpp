/*
 * @lc app=leetcode.cn id=155 lang=cpp
 *
 * [155] 最小栈
 */

#include <iostream>
#include <stack>
#include <iostream>

using namespace std;


// @lc code=start
class MinStack {
private:
    stack<int> ele_stack;
    stack<int> min_stack;

public:
    MinStack() {
        min_stack.push(INT_MAX);
    }
    
    void push(int val) {
        ele_stack.push(val);
        min_stack.push(min(val, min_stack.top()));
    }
    
    void pop() {
        ele_stack.pop();
        min_stack.pop();
    }
    
    int top() {
        return ele_stack.top();
    }
    
    int getMin() {
        return min_stack.top();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
// @lc code=end

