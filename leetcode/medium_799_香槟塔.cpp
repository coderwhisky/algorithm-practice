/*
 * @lc app=leetcode.cn id=799 lang=cpp
 *
 * [799] 香槟塔
 */

// @lc code=start


#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    double champagneTower(int poured, int query_row, int query_glass) {
        std::vector<double> row = {(double) poured};

        for (int i = 1; i <= query_row; i++) {
            std::vector<double> next_row(i+1, 0.0);
            for (int j = 0; j < row.size(); j++) {
                double volumn = row[j];
                if (volumn > 1.0) {
                    next_row[j] += (volumn - 1) / 2;
                    next_row[j+1] += (volumn - 1) / 2;
                }
            }
            row = next_row;
        }
        return std::min(row[query_glass], 1.0);
    }
};
// @lc code=end

