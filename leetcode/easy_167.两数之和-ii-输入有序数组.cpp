/*
 * @Author: your name
 * @Date: 2021-08-23 21:29:17
 * @LastEditTime: 2021-08-23 21:35:12
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/easy_167.两数之和-ii-输入有序数组.cpp
 */
/*
 * @lc app=leetcode.cn id=167 lang=cpp
 *
 * [167] 两数之和 II - 输入有序数组
 */

#include <vector>

using namespace std;


// @lc code=start
class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int left = 0, right = numbers.size() - 1;
        vector<int> sum_idx;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                sum_idx.push_back(left+1);
                sum_idx.push_back(right+1);
                break;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return sum_idx;
    }
};
// @lc code=end

