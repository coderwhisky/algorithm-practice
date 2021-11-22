/*
 * @lc app=leetcode.cn id=19 lang=cpp
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start

#include <iostream>
using namespace std;

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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* fake_head = new ListNode(0, head);
        ListNode* fast = head;
        ListNode* slow = fake_head;
        while ( n > 0 ) {
            fast = fast->next;
            n -= 1;
        }
        while (fast)
        {
            fast = fast->next;
            slow = slow->next;
        }
        ListNode* to_del = slow->next;
        slow->next = slow->next->next;
        delete to_del;
        ListNode* ans = fake_head->next;
        delete fake_head;
        return ans;
    }
};
// @lc code=end

