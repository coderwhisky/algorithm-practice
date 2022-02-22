/*
 * @Author: your name
 * @Date: 2022-02-22 07:46:28
 * @LastEditTime: 2022-02-22 08:31:47
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \algorithm-practice\leetcode\medium_912_排序数组.cpp
 */
/*
 * @lc app=leetcode.cn id=912 lang=cpp
 *
 * [912] 排序数组
 */

#include <iostream>
#include <vector>
#include <algorithm>
#include <stdlib.h>


// @lc code=start
class Solution {
public:
    std::vector<int> sortArray(std::vector<int>& nums) {
        quickSort(nums, 0, (int)nums.size() - 1);
        return nums;
    }

    int quickSort(std::vector<int> &array, int low, int high) {
        if (low < high) {
            int pos = random_partition(array, low, high);
            quickSort(array, low, pos - 1);
            quickSort(array, pos + 1, high);
        }
        return 0;
    }  

    int random_partition(std::vector<int> &array, int low, int high) {
        int i = std::rand() % (high - low + 1) + 1;
        std::swap(array[i], array[high]);
        return partition(array, low, high);
    }

    int partition(std::vector<int> &array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j <= high-1; j++) {
            if (array[j] <= pivot) {
                i = i + 1;
                std::swap(array[i], array[j]);
            }
        }
        std::swap(array[i+1], array[high]);
        return i+1;
    }
};
// @lc code=end

