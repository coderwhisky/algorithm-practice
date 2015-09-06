package org.buaa.nlp.cj.nowcoder_BAT_vedio._2015_08_12;

import java.util.Stack;

/**
 * 1、如何仅用递归函数和栈操作逆序一个栈
 【题目】
 一个栈依次压入1,2,3,4,5那么从栈顶到栈底分别为5,4,3,2,1。将这个栈转置后，从栈顶到栈底为1,2,3,4,5，也就是实现栈中元素的逆序，但是只能用递归函数来实现，而不能用另外的数据结构。
 【难度】
 尉 ★★☆☆
 * Created by whisky-yonk on 9/5/2015.
 */
public class _1_StackReverser {
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;
        int i = getAndRemoveLastEle(stack);
        reverse(stack);
        stack.push(i);
    }

    public static int getAndRemoveLastEle(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastEle(stack);
            stack.push(result);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.toString());
        reverse(stack);
        System.out.println(stack.toString());
    }
}
