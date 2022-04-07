/*
 * @Author: your name
 * @Date: 2022-03-31 07:05:36
 * @LastEditTime: 2022-04-07 23:07:21
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: /algorithm-practice/leetcode/medium_752_打开转盘锁.cpp
 */

/*
 * @lc app=leetcode.cn id=752 lang=cpp
 *
 * [752] 打开转盘锁
 */

#include <iostream>
#include <queue>
#include <vector>
#include <string>
#include <unordered_set>

using namespace std;


// @lc code=start
class Solution {
public:
    int openLock(std::vector<std::string>& deadends, std::string target) {
        if ("0000" ==  target) {
            return 0;
        }

        auto prev_num = [](char x) -> char {
            return (x == '0' ? '9' : x - 1);
        };
        auto next_num = [](char x) -> char {
            return (x == '9' ? '0' : x + 1);
        };

        auto get_next_nodes = [&](std::string cur_seq) -> std::vector<std::string> {
            std::vector<std::string> ret;
            for (int i = 0; i < 4; i++) {
                char cur_num = cur_seq[i];
                cur_seq[i] = prev_num(cur_num);
                ret.push_back(cur_seq);
                cur_seq[i] = next_num(cur_num);
                ret.push_back(cur_seq);
                cur_seq[i] = cur_num;
            } 
            return ret;
        };

        unordered_set<string> dead(deadends.begin(), deadends.end());
        if (dead.count("0000")) {
            return -1;
        }

        std::queue<pair<std::string, int>> step_q;
        step_q.push(std::make_pair("0000", 0));
        std::unordered_set<string> seen = {"0000"};
        while (!step_q.empty()) {
            pair<std::string, int> cur_node = step_q.front();
            step_q.pop();
            std::string cur_seq = cur_node.first;
            int cur_step = cur_node.second;
            for (auto&& next_node : get_next_nodes(cur_seq)) {
                if (! seen.count(next_node) && !dead.count(next_node)) {
                    if (next_node == target) {
                        return cur_step + 1;
                    }
                    step_q.emplace(next_node, cur_step + 1);
                    seen.insert(next_node);
                }
            }
        }
        return -1;
    }
};
// @lc code=end

