/*
 * @Author: your name
 * @Date: 2021-08-26 07:51:50
 * @LastEditTime: 2021-08-26 07:53:31
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/easy_53.最大子序和.cpp
 */
/*
 * @lc app=leetcode.cn id=53 lang=cpp
 *
 * [53] 最大子序和
 */


#include <vector>
#include <algorithm>
using namespace std;


// @lc code=start
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int max_sum = nums[0];
        int pre_max = 0;

        for (int i = 0; i < nums.size(); i++) {
            pre_max = max(pre_max + nums[i], nums[i]);
            max_sum = max(pre_max, max_sum);
        }
        return max_sum;
    }
};
// @lc code=end

