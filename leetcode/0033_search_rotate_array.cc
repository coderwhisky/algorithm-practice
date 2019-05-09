/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.
* File Name : 33_search_rotate_array.cc
* Purpose :
* Creation Date : 2019-02-25 20:41:10
* Last Modified : 2019-02-26 09:39:38
* Created By : chenjiang
* Modified By : chenjiang
_._._._._._._._._._._._._._._._._._._._._.*/

/* 
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int first = 0; int last = nums.size();
        while (first != last) {
            int mid = first + (last - first) / 2;
            cout<< "first: "<< first << "last: "<< last << endl;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[first] <= nums[mid]) {
                if (nums[first] <= target && target < nums[mid]) {
                    last = mid;
                } else {
                    first = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[last-1]) {
                    first = mid + 1;
                } else {
                    last = mid;
                }
            }
        }
        return -1;
    }
};


int main(int argc, char *argv[]) {
    Solution *solution = new Solution();
    vector<int> nums = {4,5,6,7,0,1,2};
    int idx = solution->search(nums, 0);
    cout<< "idx: " << idx << endl;
    delete solution;
    return 0;
}



