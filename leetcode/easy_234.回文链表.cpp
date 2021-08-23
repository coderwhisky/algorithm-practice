/*
 * @Author: your name
 * @Date: 2021-08-23 21:36:50
 * @LastEditTime: 2021-08-23 23:28:36
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /leetcode/easy_234.回文链表.cpp
 */
/*
 * @lc app=leetcode.cn id=234 lang=cpp
 *
 * [234] 回文链表
 */

#include <iostream>

using namespace std;

// @lc code=start
// Definition for singly-linked list.

// struct ListNode {
//     int val;
//     ListNode *next;
//     ListNode() : val(0), next(nullptr) {}
//     ListNode(int x) : val(x), next(nullptr) {}
//     ListNode(int x, ListNode *next) : val(x), next(next) {}
// };

class Solution {
public:
    bool isPalindrome(ListNode* head) {
        if (head == nullptr) return false;
        ListNode* rightHead = slowFastPtr(head);
        ListNode* reversedRight = reverseList(rightHead->next);
        ListNode* p_left = head;
        ListNode* p_right = reversedRight;
        bool lr_match = true;
        while (p_right != nullptr)
        {
            if (p_left->val == p_right->val) {
                p_left = p_left->next;
                p_right = p_right->next;
            } else {
                lr_match = false;
                break;
            }
        }
        rightHead->next = reverseList(reversedRight);
        return lr_match;
        
    }

    ListNode* reverseList(ListNode* head) {
        ListNode* curr = head;
        ListNode* newHead = nullptr;
        while (curr != nullptr)
        {
            ListNode* tmp_next = curr->next;
            curr->next = newHead;
            newHead = curr;
            curr = tmp_next;
        }
        return newHead;
    }

    ListNode* slowFastPtr(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast->next != nullptr && fast->next->next != nullptr)
        {
            fast = fast->next->next;
            slow = slow->next;
        }
        return slow; 
    }
};
// @lc code=end

