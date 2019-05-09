/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.
* File Name : 0239_sliding_window_maximum.cc
* Purpose :
* Creation Date : 2019-03-08 18:33:00
* Last Modified : 2019-03-12 11:55:55
* Created By : chenjiang
* Modified By : chenjiang
_._._._._._._._._._._._._._._._._._._._._.*/

/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note: 
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
*/



#include <iostream>
#include <vector>

using namespace std;

class Solution {
    public:
        vector<int> maxSlidingWindow(vector<int>& nums, int k) {
            vector<int> left(nums.size());
            vector<int> right(nums.size());
            vector<int> result;
            if (nums.size() == 0) 
                return nums;
            int left_max = nums[0];
            for (int i = 0; i < nums.size(); i++) {
                if (i % k == 0) {
                    left_max = nums[i];
                }else
                    left_max = nums[i] > left_max ? nums[i] : left_max;
                left[i] = left_max;
            }
            // cout << "left: " <<endl;
            // for (int i = 0; i < left.size(); i ++) {
            //     cout<< left[i] << " ";
            // }
            // cout << endl;
            int right_max = nums[nums.size()-1];
            for (int j = nums.size()-1; j >= 0; j--) {
                if ((nums.size() - j) % k == 0) {
                    right_max = nums[j];
                } else
                    right_max = nums[j] > right_max ? nums[j] : right_max;
                right[j] = right_max;
            }
            // cout << "right: " <<endl;
            // for (int i = 0; i < right.size(); i ++) {
            //     cout<< right[i] << " ";
            // }
            // cout << endl;
            for (int i = 0; i < nums.size()-k+1; i++) {
                int j = i+k-1;
                int tmp_max = (right[i] > left[j]) ? right[i] : left[j];
                result.push_back(tmp_max);
            }
            return result;
        }
};


int main(int argc, char *argv[]) {
    Solution *solution = new Solution();
    vector<int> nums = {1, 3, -1, -3, 5, 3, 6, 7};
    vector<int> res = solution->maxSlidingWindow(nums, 3);
    for (int i = 0; i < res.size(); i++) {
        cout<< res[i] << " ";
    }
    cout<<endl;
}



