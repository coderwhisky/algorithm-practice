package org.buaa.nlp.cj.baseAlgorithm.queue;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/7/12.
 */
public class LinkQueue<T> implements Serializable{
    public class Node {
        private T data;
        private Node next;
        public Node() {
        }
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public LinkQueue() {
        front = null;
        rear = null;
    }

    public LinkQueue(T element) {
        front = new Node(element, null);
        rear = front;
        size++;
    }

    public int size() {
        return size;
    }

    public void offer(T element) {
        if (front == null) {
            front = new Node(element, null);
            rear = front;
        } else {
            Node newNode = new Node(element, null);
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T poll() {
        Node oldNode = front;
        front = front.next;
        oldNode.next = null;
        size--;
        return (T) oldNode.data;
    }

    public T peek() {
        return rear.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    public String toString() {
        //链队列为空链队列时
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (Node current = front; current != null; current = current.next) {
                sb.append(current.data.toString() + ", ");
            }
            int len = sb.length();
            return sb.delete(len - 2, len).append("]").toString();
        }
    }

    public static void main(String[] args) {
        LinkQueue<String> queue = new LinkQueue<String>("aaaa");
        //添加两个元素
        queue.offer("bbbb");
        queue.offer("cccc");
        System.out.println(queue);
        //删除一个元素后
        queue.poll();
        System.out.println("删除一个元素后的队列：" + queue);
        //再次添加一个元素
        queue.offer("dddd");
        System.out.println("再次添加元素后的队列：" + queue);
        //删除一个元素后，队列可以再多加一个元素
        queue.poll();
        //再次加入一个元素
        queue.offer("eeee");
        System.out.println(queue);
    }
}
