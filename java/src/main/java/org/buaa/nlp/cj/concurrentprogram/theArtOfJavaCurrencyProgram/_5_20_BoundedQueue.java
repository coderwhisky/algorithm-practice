package org.buaa.nlp.cj.concurrentprogram.theArtOfJavaCurrencyProgram;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2015/9/30.
 */
public class _5_20_BoundedQueue<T> {
    private Object[] items;
    private int addIdx, removeIdx, count;
    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    public _5_20_BoundedQueue(int size) {
        items = new Object[size];
    }

    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
                full.await();
            items[addIdx] = t;
            if (++addIdx == items.length)
                addIdx = 0;
            ++count;
            empty.signal();
        }finally {
            lock.unlock();
        }
    }

    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                empty.await();
            Object x = items[removeIdx];
            if (++removeIdx == items.length)
                removeIdx = 0;
            --count;
            full.signal();
            return (T) x;
        } finally {
            lock.unlock();
        }
    }
}
