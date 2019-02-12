package org.buaa.nlp.cj.leetcode;

import java.util.LinkedList;
/**
 * Created by Administrator on 2015/10/9.
 */
public class test1 {
        private static int m, n;

        public static int numIslands(int[][] grid) {
            m = grid.length;
            if (m == 0) return 0;
            n = grid[0].length;
            if (n == 0) return 0;

            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 1) continue;

                    ans++;
                    dfs(grid, i, j);
                }
            }
            return ans;
        }


        public static void dfs(int[][] grid, int i, int j) {
            if (i < 0 || i >= m || j < 0 || j >= n) return;

            if (grid[i][j] == 1) {
                grid[i][j] = 2;
                dfs(grid, i - 1, j);
                dfs(grid, i + 1, j);
                dfs(grid, i, j - 1);
                dfs(grid, i, j + 1);
            }
        }

    public static void main(String[] args) {
        int[][] case1={
                {0,0,0,0,0},
                {0,1,1,0,0},
                {0,0,1,1,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };
        int ser = numIslands(case1);
        System.out.println(ser);
    }
}
