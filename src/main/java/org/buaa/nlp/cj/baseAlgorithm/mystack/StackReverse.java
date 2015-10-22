package org.buaa.nlp.cj.baseAlgorithm.mystack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Administrator on 2015/10/20.
 */
public class StackReverse {
    public static void reverse(Stack<Integer> stack) {
        if (stack.size() == 0) return;
        int a = stack.pop();
        if (stack.size() == 0) {
            stack.push(a);
            return;
        }
        reverse(stack);
        int b = stack.pop();
        reverse(stack);
        stack.push(a);
        reverse(stack);
        stack.push(b);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

//        int i = 0;
//        while (!stack.isEmpty()) {
//            System.out.print(stack.elementAt(i) + " ");
//            i++;
//        }
//        System.out.println();
        reverse(stack);
//        System.out.println(Arrays.);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
