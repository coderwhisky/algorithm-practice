/*
 * @lc app=leetcode.cn id=200 lang=cpp
 *
 * [200] 岛屿数量
 */

#include <iostream>
#include <vector>

using namespace std;


// @lc code=start
class Solution {
public:
    void dfs(vector<vector<char>> &grid, int x, int y) {
        int nr = grid.size();
        int nc = grid[0].size();
        grid[x][y] = '0';

        if (x-1 >= 0 && grid[x-1][y] == '1') dfs(grid, x-1, y);
        if (x+1 < nr && grid[x+1][y] == '1') dfs(grid, x+1, y);
        if (y-1 >= 0 && grid[x][y-1] == '1') dfs(grid, x, y-1);
        if (y+1 < nc && grid[x][y+1] == '1') dfs(grid, x, y+1);
    }
    int numIslands(vector<vector<char>>& grid) {
        int nr = grid.size();
        int nc = grid[0].size();
        if (nr == 0 || nc == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    ans += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }
};
// @lc code=end

