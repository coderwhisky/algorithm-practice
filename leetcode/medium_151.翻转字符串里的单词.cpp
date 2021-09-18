/*
 * @Author: your name
 * @Date: 2021-09-18 08:26:43
 * @LastEditTime: 2021-09-18 08:39:38
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/medium_151.翻转字符串里的单词.cpp
 */
/*
 * @lc app=leetcode.cn id=151 lang=cpp
 *
 * [151] 翻转字符串里的单词
 */

#include <string>
#include <algorithm>
#include <iostream>

using namespace std;


// @lc code=start
class Solution {
public:
    string reverseWords(string s) {
        // 反转整个字符串
        reverse(s.begin(), s.end());

        int n = s.size();
        int idx = 0;
        for (int start = 0; start < n; ++start) {
            if (s[start] != ' ') {
                // 填一个空白字符然后将idx移动到下一个单词的开头位置
                if (idx != 0) s[idx++] = ' ';

                // 循环遍历至单词的末尾
                int end = start;
                // cout<< "before reversed string: " << s.c_str() << endl;
                while (end < n && s[end] != ' ') s[idx++] = s[end++];
                // cout<< "after reversed string: " << s.c_str() << endl;
                // while (end < n && s[end] != ' ') {
                //     idx++;
                //     end++;
                // } 
                // cout << start << " " << end << " " << idx << endl;

                // 反转整个单词
                reverse(s.begin() + idx - (end - start), s.begin() + idx);

                // 更新start，去找下一个单词
                start = end;
            }
        }
        s.erase(s.begin() + idx, s.end());
        return s;
    }
};
// @lc code=end

