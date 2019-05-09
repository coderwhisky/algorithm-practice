/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.
* File Name : 0015_three_sum.cc
* Purpose :
* Creation Date : 2019-03-07 15:08:20
* Last Modified : 2019-03-07 15:13:25
* Created By : chenjiang
* Modified By : chenjiang
_._._._._._._._._._._._._._._._._._._._._.*/

#include <vector>
#include <iostream>
#include <unordered_map>

using namespace std;


class Solution {
    public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> res;
        unordered_map<int, int> pos_map;

        for (int i = 0; i < nums.size(); i++) {
            pos_map[nums[i]] = i;
        }
    }
};


int main(int argc, char *argv) {
    return 0;
}

