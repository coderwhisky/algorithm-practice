package org.buaa.nlp.cj.baseStructure.queue;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Administrator on 2015/7/12.
 */
public class LoopQueue<T> implements Serializable{
    private int DEFAULT_SIZE = 10;
    private int capacity;
    int front = 0;
    int rear = 0;
    private Object[] elementData;

    public LoopQueue() {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    public LoopQueue(T element) {
        this();
        elementData[0] = element;
        rear++;
    }

    public LoopQueue(T element, int initSize) {
        this.capacity = initSize;
        elementData = new Object[capacity];
        elementData[0] = element;
        rear++;
    }

    public int size() {
        if (isEmpty())
            return 0;
        return rear > front ? (rear - front) : (capacity-(front-rear));
    }

    public void add(T element) {
        if (rear == front && elementData[rear] != null)
            throw new IndexOutOfBoundsException("queue is full");
        elementData[rear++] = element;
        rear = rear == capacity ? 0 : rear;
    }

    public T remove() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("empty queue error");
        T oldValue = (T) elementData[front];
        elementData[front++] = null;
        front = front == capacity ? 0 : front;
        return oldValue;
    }

    public T element() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("empty queue error");
        return (T) elementData[front];
    }

    public void clear() {
        Arrays.fill(elementData, null);
        front = 0;
        rear = 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            //如果front < rear，有效元素就是front到rear之间的元素
            if (front < rear) {
                StringBuilder sb = new StringBuilder("[");
                for (int i = front; i < rear; i++) {
                    sb.append(elementData[i].toString() + ", ");
                }
                int len = sb.length();
                return sb.delete(len - 2, len).append("]").toString();
            }
            //如果front >= rear，有效元素为front->capacity之间、0->front之间的
            else {
                StringBuilder sb = new StringBuilder("[");
                for (int i = front; i < capacity; i++) {
                    sb.append(elementData[i].toString() + ", ");
                }
                for (int i = 0; i < rear; i++) {
                    sb.append(elementData[i].toString() + ", ");
                }
                int len = sb.length();
                return sb.delete(len - 2, len).append("]").toString();
            }
        }
    }

    public boolean isEmpty() {
        return rear == front && elementData[rear] == null;
    }

    public static void main(String[] args) {
        LoopQueue<String> queue = new LoopQueue<String>("aaaa", 3);
        //添加两个元素
        queue.add("bbbb");
        queue.add("cccc");
        //此时队列已满
        System.out.println(queue);
        //删除一个元素后，队列可以再多加一个元素
        queue.remove();
        System.out.println("删除一个元素后的队列：" + queue);
        //再次添加一个元素，此时队列又满
        queue.add("dddd");
        System.out.println(queue);
        System.out.println("队列满时的长度：" + queue.size());
        //删除一个元素后，队列可以再多加一个元素
        queue.remove();
        //再次加入一个元素，此时队列又满
        queue.add("eeee");
        System.out.println(queue);
    }
}
