package org.buaa.nlp.cj.baseAlgorithm.mystack;

import java.util.Objects;

/**
 * Created by Administrator on 2015/9/7.
 */
public class MyArrayStack implements MyStack {
    private Integer[] objs = new Integer[16];
    private int size = 0;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            objs[i] = null;
        }
        size = 0;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public boolean push(Integer data) {
        if (size >= objs.length) {
            resize();
        }
        objs[size++] = data;
        return true;
    }

    @Override
    public Integer pop() {
        if (size == 0)
            return null;
        return objs[--size];
    }

    private void resize() {
        Integer[] tmp = new Integer[objs.length*3/2 + 1];
        for (int i = 0; i < size; i++) {
            tmp[i] = objs[i];
        }
        objs = tmp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(objs[i].toString());
            if (i != size-1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
