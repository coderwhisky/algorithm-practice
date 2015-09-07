package org.buaa.nlp.cj.baseAlgorithm;

/**
 * Created by Administrator on 2015/9/7.
 */
public class Node<T> {
    public T data;
    public Node next;
    public Node() {
    }
    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
}
