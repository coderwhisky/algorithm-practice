/*
 * @Author: your name
 * @Date: 2021-08-14 22:08:32
 * @LastEditTime: 2021-08-14 23:25:43
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/easy_283.移动零.cpp
 */
/*
 * @lc app=leetcode.cn id=283 lang=cpp
 *
 * [283] 移动零
 */

#include <vector>

using namespace std;

// @lc code=start
class Solution1 {
public:
    void moveZeroes(vector<int>& nums) {
        for (int i = 0; i < nums.size(); i ++) {
            if (nums[i] == 0) {
                for (int j = i+1; j < nums.size(); j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }
};
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int left = 0, right = 0;
        while (right < nums.size()) {
            if (nums[right] != 0) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
            }
            right++;
        }
    }
};
// @lc code=end

