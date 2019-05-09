/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.
* File Name : 0001_two_sum.cc
* Purpose :
* Creation Date : 2019-03-07 14:35:59
* Last Modified : 2019-03-07 14:56:42
* Created By : chenjiang
* Modified By : chenjiang
_._._._._._._._._._._._._._._._._._._._._.*/


#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;


class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> pos_map;
        vector<int> res;
        for (int i = 0; i < nums.size(); i++) {
            pos_map[nums[i]] = i;
        } 
        for (int i = 0; i < nums.size(); i++) {
            int gap = target - nums[i];
            if (pos_map.find(gap) != pos_map.end() && pos_map[gap] > i) {
                res.push_back(i);
                res.push_back(pos_map[gap]);
                break;
            }
        }
        return res;
    }
};


int main(int argc, char *argv[]) {
    Solution *solution = new Solution();
    vector<int> nums = {2, 7, 11, 15};
    vector<int> res = solution->twoSum(nums, 9); 
    cout<< "idx1: " << res[0] << "\tidx2: " << res[1]<< endl;
    return 0;
}
