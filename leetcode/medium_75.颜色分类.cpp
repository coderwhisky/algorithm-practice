/*
 * @Author: your name
 * @Date: 2021-08-16 23:18:39
 * @LastEditTime: 2021-08-16 23:52:29
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/medium_75.颜色分类.cpp
 */
/*
 * @lc app=leetcode.cn id=75 lang=cpp
 *
 * [75] 颜色分类
 */

#include <vector>

using namespace std;

// @lc code=start
class Solution {
public:
    void sortColors(vector<int>& nums) {
        int left = 0, right = nums.size() - 1;
        for (int i = 0; i <= right; i++) {
            while(nums[i] == 2 && i <= right) {
                int tmp = nums[right];
                nums[right] = nums[i];
                nums[i] = tmp;
                right--;
            }  
            if (nums[i] == 0) {
                int tmp = nums[left];
                nums[left] = nums[i];
                nums[i] = tmp;
                left++;
            } 

        }
        
    }
};
// @lc code=end

