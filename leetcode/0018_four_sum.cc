/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.
* File Name : 0018_four_sum.cc
* Purpose :
* Creation Date : 2019-03-07 15:20:41
* Last Modified : 2019-03-07 16:03:53
* Created By : chenjiang
* Modified By : chenjiang
_._._._._._._._._._._._._._._._._._._._._.*/

/*
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/

#include <iostream>
#include <vector>
#include <unordered_map>
#include <utility>

using namespace std;


class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> result;
        if (nums.size() < 4) {return result;}
        sort(nums.begin(), nums.end());
        unordered_map<int, vector<pair<int, int>>> pos_map;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i+1; j < nums.size(); j++) {
                int tmp_sum = nums[i] + nums[j];
                pos_map[tmp_sum].push_back(pair<int, int>(i,j));
            }
        }
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i+1; j < nums.size(); j++) {
                int key = target - nums[i] - nums[j];
                if (pos_map.find(key) == pos_map.end()) 
                    continue;
                // vector<pair<int,int>> tmp_vec = pos_map.find(key);
                auto tmp_vec = pos_map[key];
                for (int k = 0; k < tmp_vec.size(); k++) {
                    if (i <= tmp_vec[k].second)
                        continue;
                    result.push_back({nums[tmp_vec[k].first], nums[tmp_vec[k].second], 
                                      nums[i], nums[j]});
                }
            }
        }
        sort(result.begin(), result.end());
        result.erase(unique(result.begin(), result.end()), result.end());
        return result;
    }
};


int main(int argc, char *argv[]) {
    Solution *solution = new Solution();
    vector<int> nums = {1, 0, -1, 0, -2, 2};
    vector<vector<int>> res = solution->fourSum(nums, 0);
    cout<< "result size: " << res.size() <<endl;
    return 0;
}


