package org.buaa.nlp.cj.cci150._8_2;

import org.buaa.nlp.cj.cci150.CCINode;

import java.util.Stack;

/**
 * Created by Administrator on 2015/9/6.
 */
public class _2_7_PalindromeList {
    // ========== method 1 start: time:o(n),space:o(n) =============
    // use a stack
    public boolean isPalindrome(CCINode head) {
        CCINode slow = head;
        CCINode fast = head;

        Stack<Integer> stack = new Stack<Integer>();
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            int v1 = slow.val;
            int v2 = stack.pop();
            if (v1 != v2) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
    // ========== method 1 end =============

    public static void main(String[] args) {
        CCINode head = new CCINode(1);
        head.next = new CCINode(2);
        head.next.next = new CCINode(3);
        head.next.next.next = new CCINode(2);
        head.next.next.next.next = new CCINode(1);
        head.next.next.next.next.next = new CCINode(0);
        boolean result = new _2_7_PalindromeList().isPalindrome(head);
        System.out.println(result);
    }
}
