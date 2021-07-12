/*
 * @Author: your name
 * @Date: 2021-07-12 23:10:34
 * @LastEditTime: 2021-07-12 23:45:54
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /asr-kaldi-streaming-dev-reconstruct-0608/data1/chenjiang/algorithm-practice/leetcode/medium_2.两数相加.cpp
 */
/*
 * @lc app=leetcode.cn id=2 lang=cpp
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 */

#include <iostream>

using namespace std;

 // struct ListNode {
 //     int val;
 //     ListNode *next;
 //     ListNode() : val(0), next(nullptr) {}
 //     ListNode(int x) : val(x), next(nullptr) {}
 //     ListNode(int x, ListNode *next) : val(x), next(next) {}
 // };
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *head = nullptr, *tail = nullptr;
        int carry = 0;
        while (l1 || l2)
        {
            int num1 = l1 ? l1->val : 0;
            int num2 = l2 ? l2->val : 0;
            int sum = carry + num1 + num2;
            if (!head) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail->next = new ListNode(sum % 10);
                tail = tail->next;
            }
            if (l1) {
                l1 = l1->next;
            }
            if (l2) {
                l2 = l2->next;
            }
            carry = sum / 10;
        }
        if (carry > 0) {
            tail->next = new ListNode(carry);
        }
        return head;     
    }
};
// @lc code=end

