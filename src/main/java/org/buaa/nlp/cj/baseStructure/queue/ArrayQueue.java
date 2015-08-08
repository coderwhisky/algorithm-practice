package org.buaa.nlp.cj.baseStructure.queue;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 顺序队列
 * Created by Administrator on 2015/7/12.
 */
public class ArrayQueue<T> implements Serializable {
    private int DEFAULT_SIZE = 10;
    private int capacity;
    private Object[] elementData;
    private int front = 0;
    private int rear = 0;

    public ArrayQueue() {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    public ArrayQueue(T element) {
        this();
        elementData[0] = element;
        rear++;
    }

    public ArrayQueue(int initSize) {
        elementData = new Object[initSize];
    }

    public ArrayQueue(T element, int initSize) {
        this.capacity = initSize;
        elementData = new Object[capacity];
        elementData[0] = element;
        rear++;
    }

    public int size() {
        return rear - front;
    }

    public void offer(T element) {
        ensureCapacity(rear +1);
        elementData[rear++] = element;
    }

    /**
     * dequeue
     * @return
     */
    public T poll() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("empty queue exception");
        T oldValue = (T)elementData[front];
        elementData[front++] = null;
        return oldValue;
    }

    public T peek() {
        if (isEmpty())
            throw  new IndexOutOfBoundsException("empty queue exception");
        return (T) elementData[front];
    }


    public void ensureCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = (oldCapacity*3)/2 + 1;
            if (newCapacity < minCapacity)
                newCapacity = minCapacity;
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    public void clear() {
        Arrays.fill(elementData, null);
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (int i = front; i < rear; i++) {
                sb.append(elementData[i] + ",");
            }
            int len = sb.length();
            return sb.delete(len - 1, len).append("]").toString();
        }
    }
}
