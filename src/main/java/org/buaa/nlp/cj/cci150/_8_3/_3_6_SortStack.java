package org.buaa.nlp.cj.cci150._8_3;

import java.util.Stack;

/**
 * Created by Administrator on 2015/9/8.
 */
public class _3_6_SortStack {
    public Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> res = new Stack<Integer>();
        while (!s.isEmpty()) {
            int tmp = s.pop();
            while (!res.isEmpty() && res.peek() > tmp) {
                s.push(res.pop());
            }
            res.push(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(2);
        stack.push(49);
        stack.push(34);
        stack.push(21);
        stack.push(33);
        Stack<Integer> res = new _3_6_SortStack().sort(stack);
        System.out.println(res.elements().toString());
    }
}
