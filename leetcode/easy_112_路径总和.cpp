/*
 * @lc app=leetcode.cn id=112 lang=cpp
 *
 * [112] 路径总和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 */
// struct TreeNode {
//     int val;
//     TreeNode *left;
//     TreeNode *right;
//     TreeNode() : val(0), left(nullptr), right(nullptr) {}
//     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
//     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
// };

#include <iostream>
#include <stack>

using namespace std;

class Solution {
public:
    bool hasPathSum(TreeNode *root, int targetSum) {
        if (!root) return false;
        std::stack<TreeNode*> visitStack;
        visitStack.push(root);
        while (! visitStack.empty()) {
            TreeNode *top = visitStack.top();
            visitStack.pop();
            if (!top->left && !top->right) {
                if (top->val == targetSum) {
                    return true;
                }
            }
            if (top->left != nullptr) {
                top->left->val = top->left->val + top->val;
                visitStack.push(top->left);
            }
            if (top->right != nullptr) {
                top->right->val = top->right->val + top->val;
                visitStack.push(top->right);
            }
        }
       return false; 
    }

    bool hasPathSum2(TreeNode* root, int targetSum) {
        if (!root) {
            return false;
        }        
        if (!root->left && !root->right) {
            return targetSum == root->val;
        }
        bool inLeft = (root->left && hasPathSum(root->left, targetSum-root->val));
        bool inRight = (root->right && hasPathSum(root->right, targetSum - root->val));
        return inLeft || inRight;
    }
};
// @lc code=end

