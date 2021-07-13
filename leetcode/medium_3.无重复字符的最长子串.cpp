/*
 * @Author: your name
 * @Date: 2021-07-13 07:38:49
 * @LastEditTime: 2021-07-14 00:10:06
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /asr-kaldi-streaming-dev-reconstruct-0608/data1/chenjiang/algorithm-practice/leetcode/medium_3.无重复字符的最长子串.cpp
 */
/*
 * @lc app=leetcode.cn id=3 lang=cpp
 *
 * [3] 无重复字符的最长子串
 */

#include <string>
#include <queue>
#include <set>

using namespace std;

// @lc code=start
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        queue<char> q_sub_str;
        set<char> exist_str;
        int max_sub_len = 0;
        if (s.size() < 2) {
            return s.size();
        }
        for (int i = 0; i < s.size(); i++) {
            char tmp_char(s.at(i));
            if (exist_str.find(tmp_char) == exist_str.end()) {
                exist_str.insert(tmp_char);
                q_sub_str.push(tmp_char);
                if (max_sub_len < q_sub_str.size()) {
                    max_sub_len = q_sub_str.size();
                }
            } else {
                char head_char = q_sub_str.front();
                while (tmp_char != head_char)
                {
                    q_sub_str.pop();
                    exist_str.erase(head_char);
                    head_char = q_sub_str.front();
                }
                q_sub_str.pop();
                exist_str.erase(head_char);

                exist_str.insert(tmp_char);
                q_sub_str.push(tmp_char);
            }
        }
        return max_sub_len;
    }
};
// @lc code=end

