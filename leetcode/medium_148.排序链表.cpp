/*
 * @lc app=leetcode.cn id=148 lang=cpp
 *
 * [148] 排序链表
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
    ListNode* sortList(ListNode* head) {
        if (head == nullptr) {
            return head;
        }
        int length = 0;
        ListNode* idx_ptr = head;
        while (idx_ptr != nullptr)
        {
            length += 1;
            idx_ptr = idx_ptr->next;
        }
        ListNode* dummyHead = new ListNode(0, head);
        for (int sublen = 1; sublen < length; sublen <<= 1) {
            ListNode* prev = dummyHead, *curr = dummyHead->next;
            while (curr != nullptr)
            {
                ListNode* head1 = curr;
                for (int i = 1; i < sublen && curr->next != nullptr; i++) {
                    curr = curr->next;
                }
                ListNode* head2 = curr->next;
                curr->next = nullptr;
                curr = head2;
                for (int i = 1; i < sublen && curr != nullptr && curr->next != nullptr; i++) {
                    curr = curr->next;
                }
                ListNode* next = nullptr;
                if (curr != nullptr) {
                    next = curr->next;
                    curr->next = nullptr;
                }
                ListNode* merged = merge(head1, head2);
                prev->next = merged; 
                while (prev->next != nullptr) {
                    prev = prev->next;
                }
                curr = next;
            }
        }
        return dummyHead->next;
        
    }
    ListNode* merge(ListNode* head1, ListNode* head2) {
        ListNode* dumpHead = new ListNode(0);
        ListNode* temp = dumpHead, *temp1 = head1, *temp2 = head2;

        while (temp1 != nullptr && temp2 != nullptr)
        {
            if (temp1->val < temp2->val) {
                temp->next = temp1;
                temp1 = temp1->next;
            } else {
                temp->next = temp2;
                temp2 = temp2->next;
            }
            temp = temp->next;
        }
        if (temp1 != nullptr) {
            temp->next = temp1;
        }
        if (temp2 != nullptr) {
            temp->next = temp2;
        }
        return dumpHead->next;
    }
};



// merge sort from top to buttom using 
class Solution1 {
public:
    ListNode* sortList(ListNode* head) {
        return sortList(head, nullptr);
    }
    ListNode* sortList(ListNode* head, ListNode* tail) {
        if (head == nullptr) {
            return head;
        }
        if (head->next == tail) {
            head->next = nullptr;
            return head;
        }
        // get mid of list
        ListNode* slow = head, *fast = head;
        while (fast != tail)
        {
            slow = slow->next;
            fast = fast->next;
            if (fast != tail) {
                fast = fast->next;
            }
        }
        ListNode* mid = slow;
        return merge(sortList(head, mid), sortList(mid, tail)) ;
    }

    ListNode* merge(ListNode* head1, ListNode* head2) {
        ListNode* dummyHead = new ListNode(0);
        ListNode* temp = dummyHead, *temp1 = head1, *temp2 = head2;
        while (temp1 != nullptr && temp2 != nullptr)
        {
            if (temp1->val < temp2->val)
            {
                temp->next = temp1;
                temp1 = temp1->next;
            } else {
                temp->next = temp2;
                temp2 = temp2->next;
            }
            temp = temp->next;
        }
        if (temp1 != nullptr)
        {
            temp->next = temp1;
        }
        if (temp2 != nullptr)
        {
            temp->next = temp2;
        }
        return dummyHead->next;
    }
};
// @lc code=end

