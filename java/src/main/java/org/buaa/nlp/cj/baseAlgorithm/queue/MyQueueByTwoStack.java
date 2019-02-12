package org.buaa.nlp.cj.baseAlgorithm.queue;

import java.util.Stack;

/**
 * Created by Administrator on 2015/9/8.
 */
public class MyQueueByTwoStack<T> {
    Stack<T> stackNewest, stackOldest;

    public MyQueueByTwoStack() {
        // 相当于队尾
        this.stackNewest = new Stack<T>();
        // 相当于队首
        this.stackOldest = new Stack<T>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value) {
        stackNewest.push(value);
    }

    /**
     * move the elements in {@link this.stackNewest} to {@linkplain this.stackOldest}
     * this fun will be call only by stackOldest is empty;
     */
    public void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    public T remove() {
        shiftStacks();
        return stackOldest.pop();
    }

    public static void main(String[] args) {
        MyQueueByTwoStack<Integer> myQueue = new MyQueueByTwoStack<Integer>();
        myQueue.add(2);
        myQueue.add(5);
        myQueue.add(4);
        System.out.println(myQueue.remove());
    }
}
