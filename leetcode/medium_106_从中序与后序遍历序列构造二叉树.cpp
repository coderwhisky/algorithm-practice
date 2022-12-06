/*
 * @lc app=leetcode.cn id=106 lang=cpp
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 */

#include <iostream>
#include <unordered_map>

using namespace std;


// struct TreeNode {
//     int val;
//     TreeNode *left;
//     TreeNode *right;
//     TreeNode() : val(0), left(nullptr), right(nullptr) {}
//     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
//     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
// };


class Solution {
    int post_idx = 0;
    unordered_map<int, int> value_idx_map;    
public:

    TreeNode* helper(int left, int right, vector<int> &inorder, vector<int> &postorder) {
        if (left > right) {
            return nullptr;
        }
        int root_val = postorder[post_idx];
        TreeNode *root = new TreeNode(root_val);

        int inorder_idx = value_idx_map[root_val];
        post_idx--;

        root->right  = helper(inorder_idx+1, right, inorder, postorder);
        root->left = helper(left, inorder_idx-1, inorder, postorder);
        return root;

    }

    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        post_idx = postorder.size() - 1;
        for (int idx = 0; idx < inorder.size(); idx++) {
            value_idx_map[inorder[idx]] = idx;
        }
        return helper(0, inorder.size() - 1, inorder, postorder);
    }
};
// @lc code=end

