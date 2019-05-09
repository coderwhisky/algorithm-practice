/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.
* File Name : 35_searchInsert.cc
* Purpose :
* Creation Date : 2019-02-25 21:44:52
* Last Modified : 2019-03-07 14:26:49
* Created By : chenjiang
* Modified By : chenjiang
_._._._._._._._._._._._._._._._._._._._._.*/


/* Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
*/


#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {    
        int left = 0; int right = nums.size()-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
};



int main(int argc, char *argv[]) {
    Solution *solution = new Solution();
    vector<int> nums = {1, 2, 3, 5};
    int insert_idx = solution->searchInsert(nums, 5);
    cout<< "insert pos: "<< insert_idx <<endl;
    delete solution;
    return 0;
}
