package org.buaa.nlp.cj.baseAlgorithm.mystack;

import java.util.Objects;

/**
 * 来源：http://www.cnblogs.com/youxin/p/4371165.html
 * 问题描述：
 一个整数栈stack，具有push和pop操作，其时间空间复杂度皆为O(1)。
 设计算法max操作，求栈中的最大值，该操作的时间空间复杂度也要求为O(1)。
 可以修改栈的存储方式，push，pop的操作，但是要保证O(1)的时间空间复杂度。



 算法描述：

 变量Max保存当前最大元素值，初始值为最小整数m。



 1. 当push入栈时，将（当前元素-Max）存入栈中，

 若当前元素小于Max，栈中元素为负数；

 若当前元素大于等于Max，栈中元素为非负数，将Max替换为当前元素。



 2. 当pop出栈时，

 若栈中元素为负数，则将（栈中元素+Max）弹出栈；

 若栈中元素为非负数，则将Max弹出栈，并将Max替换为（Max-栈中元素）。



 3. Max即为当前栈中最大元素值。





 主要思路是将最大值以某种方式在原有栈中标记出来，从而减少空间使用。可以用正负数来区分普通元素和最大值元素：

 普通元素使用负数存储（元素-Max）；

 最大值元素使用非负数存储（New Max - Old Max）；

 这样便可在栈中区分普通元素和最大值元素，并可通过Max恢复Old Max。

 分析 by CJ:

 push(data) 时，栈顶元素是 tmp = data-oldMax ( oldMax 是上一次的最大值，newMax 是当前的最大值)
 当 tmp < 0 时， 入栈的是 tmp = data - oldMax; 此时 newMax = oldMax, 故 pop() 时，data = tmp + oldMax = tmp + newMax (弹出)， oldMax = newMax （更新oldMax）;
 当 tmp >=0 时， 入栈的是 tmp = data - oldMax; 此时 newMax = data, 故pop() 时，data = newMax (弹出)，oldMax = data - tmp = newMax - tmp（更新oldMax）
 * Created by Administrator on 2015/9/7.
 */
public class MyStackWithMax implements MyStack {
    private Integer[] objs = new Integer[16];
    private int size = 0;
    private Integer max = -999999;
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            objs[i] = null;
        size = 0;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public boolean push(Integer data) {
        if (size >= objs.length)
            resize();
        Integer tmp = data - max;
        objs[size++] = tmp;
        if (tmp >= 0) {
            max = data;
        }
        return true;
    }

    @Override
    public Integer pop() {
        if (size == 0)
            return null;
        Integer tmp = objs[--size];
        Integer top;
        if (tmp < 0){
            top = tmp + max;
        } else {
            top = max;
            max = max - tmp;
        }
        return top;
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

    public static void main(String[] args) {
        MyStackWithMax myStackWithMax = new MyStackWithMax();
        myStackWithMax.push(5);
        System.out.println("stack elements: " + myStackWithMax.toString() + " max: " + myStackWithMax.max);
        myStackWithMax.push(6);
        System.out.println("stack elements: " + myStackWithMax.toString() + " max: " + myStackWithMax.max);
        myStackWithMax.push(-1);
        System.out.println("stack elements: " + myStackWithMax.toString() + " max: " + myStackWithMax.max);
        myStackWithMax.push(10);
        System.out.println("stack elements: " + myStackWithMax.toString() + " max: " + myStackWithMax.max);
        myStackWithMax.push(20);
        System.out.println("stack elements: " + myStackWithMax.toString() + " max: " + myStackWithMax.max);
        myStackWithMax.pop();
        System.out.println("stack elements: " + myStackWithMax.toString() + " max: " + myStackWithMax.max);
    }
}
