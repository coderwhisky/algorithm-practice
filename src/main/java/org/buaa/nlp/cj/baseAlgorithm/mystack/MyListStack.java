package org.buaa.nlp.cj.baseAlgorithm.mystack;

import org.buaa.nlp.cj.baseAlgorithm.Node;
import org.buaa.nlp.cj.baseAlgorithm.queue.LinkQueue;

/**
 * Created by Administrator on 2015/9/7.
 */
public class MyListStack implements MyStack {
    private Node top;
    private int size;

    public MyListStack() {
        top = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public boolean push(Integer data) {
        Node node = new Node();
        node.data = data;
        node.next = top;
        top = node;
        size++;
        return true;
    }

    @Override
    public Integer pop() {
        if (top != null) {
            Node<Integer> node = top;
            top = top.next;
            size--;
            return node.data;
        }
        return null;
    }
}
