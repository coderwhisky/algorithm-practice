package org.buaa.nlp.cj.baseAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Administrator on 2015/8/1.
 */
public class Heap<T extends Comparable<T>> {
    private List<T> items;
    private int cursor;

    public Heap() {
        items = new ArrayList<T>();
        cursor = -1;
    }

    public Heap(int size) {
        items = new ArrayList<T>(size);
        cursor = -1;
    }

    /**
     * 上移操作
     * @param index 被上移的元素的起始位置
     */
    public void siftUp(int index) {
        T intent = items.get(index);
        while (index > 0) {
            int pindex = (index-1)/2;
            T parent = items.get(pindex);
            // 上移条件，比父节点大，构造大顶堆
            if (intent.compareTo(parent) > 0) {
                items.set(index, parent);
                index = pindex;
            } else {
                break;
            }
        }
        items.set(index, intent);
    }

    /**
     * 下移操作
     * @param index 被下移的元素的起始位置
     */
    public void siftDown(int index) {
        T intent = items.get(index);
        int l_cindex = 2*index + 1;
        while (l_cindex < items.size()) {
            T maxChild = items.get(l_cindex);
            int max_cindex = l_cindex;

            int r_cindex = l_cindex + 1;
            if (r_cindex < items.size()) {
                T rChild = items.get(r_cindex);
                    if (rChild.compareTo(maxChild) > 0) {
                        maxChild = rChild;
                        max_cindex = r_cindex;
                }
            }

            if (maxChild.compareTo(intent) > 0) {
                items.set(index, maxChild);
                index = max_cindex;
                l_cindex = 2*index + 1;
            } else {
                break;
            }
        }
        items.set(index, intent);
    }

    public void add(T item) {
        items.add(item);
        // 在尾部添加元素，上移，完成重构
        siftUp(items.size() - 1);
    }

    public T delete() {
        if (items.isEmpty())
            throw new NoSuchElementException();

        T maxItem = items.get(0);
        T lastItem = items.remove(items.size() - 1);

        if (items.isEmpty())
            return lastItem;

        // 将尾部节点放置在顶部，下移，完成重构
        items.set(0, lastItem);
        siftDown(0);
        return maxItem;
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf(3).compareTo(4));
    }

}
