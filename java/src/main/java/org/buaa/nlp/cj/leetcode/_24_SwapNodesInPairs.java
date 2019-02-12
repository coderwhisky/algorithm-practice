package org.buaa.nlp.cj.leetcode;

/**
 * Created by Administrator on 2015/5/17.
 */
public class _24_SwapNodesInPairs {

    public static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null)
                return null;
            if (head.next == null)
                return head;

            ListNode i = head;
            ListNode j = head.next;
            ListNode k = j.next;
            head = head.next;
            while (j != null) {
                j.next = i;
                if (k != null && k.next != null) {  // 有偶数个节点
                    i.next = k.next;
                } else { // 奇数个节�?
                    i.next = k;
                }

                // 更新i，j, k，的值，前进两个
                i = k;
                if (k != null)
                    j = k.next;
                else
                    j = null;
                if (k != null && k.next != null) {
                    k = k.next.next;
                } else {
                    k = null;
                }
            }
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode head = new Solution().swapPairs(node1);
    }
}
