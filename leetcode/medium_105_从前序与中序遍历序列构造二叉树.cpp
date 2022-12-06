/*
 * @lc app=leetcode.cn id=105 lang=cpp
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 */

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

#include <unordered_map>

class Solution {
    int pre_idx = 0;
    unordered_map<int, int> idx_map;
public:

    TreeNode* helper(int left, int right, vector<int>& preorder, vector<int>& inorder) {
        if (left > right) return nullptr;

        int root_val = preorder[pre_idx];
        TreeNode *root = new TreeNode(root_val);
        pre_idx++;

        int in_idx = idx_map[root_val];
        root->left = helper(left, in_idx-1, preorder, inorder);
        root->right = helper(in_idx+1, right, preorder, inorder);
        return root;
    }

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        pre_idx = 0;
        for (int i = 0; i < inorder.size(); i++) {
            idx_map[inorder[i]] = i;
        }
        return helper(0, preorder.size()-1, preorder, inorder);
    }
};

// @lc code=end

