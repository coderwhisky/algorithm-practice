package org.buaa.nlp.cj.leetcode;

import java.util.*;

/**
 * Created by Administrator on 2015/8/1.
 */
public class _23_MergeKSortedList {

    public org.buaa.nlp.cj.ListNode mergeKLists2(org.buaa.nlp.cj.ListNode[] lists) {
        PriorityQueue<org.buaa.nlp.cj.ListNode> heap = new PriorityQueue<org.buaa.nlp.cj.ListNode>(10,new Comparator<org.buaa.nlp.cj.ListNode>() {
            @Override
            public int compare(org.buaa.nlp.cj.ListNode o1, org.buaa.nlp.cj.ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < lists.length; i++) {
            org.buaa.nlp.cj.ListNode node = lists[i];
            if (node != null)
                heap.offer(lists[i]);
        }

        org.buaa.nlp.cj.ListNode head = null;
        org.buaa.nlp.cj.ListNode pre = head;

        while (heap.size() > 0) {
            org.buaa.nlp.cj.ListNode cur = heap.poll();
            if (head == null) {
                head = cur;
                pre = head;
            } else {
                pre.next = cur;
            }
            pre = cur;
            if (cur.next != null) {
                heap.offer(cur.next);
            }
        }

        return head;
    }

    public org.buaa.nlp.cj.ListNode mergeKLists(org.buaa.nlp.cj.ListNode[] lists) {
        Heap<org.buaa.nlp.cj.ListNode> heap = new Heap<org.buaa.nlp.cj.ListNode>();
        for (int i = 0; i < lists.length; i++) {
            org.buaa.nlp.cj.ListNode node = lists[i];
            if (node != null)
                heap.add(lists[i]);
        }

        org.buaa.nlp.cj.ListNode head = null;
        org.buaa.nlp.cj.ListNode pre = head;

        while (heap.size > 0) {
            ListNode cur = heap.delete();
            if (head == null) {
                head = cur;
                pre = head;
            } else {
                pre.next = cur;
            }
            pre = cur;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }

        return head;
    }

    /**
     * 小顶堆
     * @param <T>
     */
    public class Heap<T extends Comparable<T>> {
        private List<T> items = new ArrayList<T>();
        private int size;

        public void add(T item) {
            items.add(item);
            siftUp(items.size() - 1);
            this.size = items.size();
        }

        public T delete() {
            if (items.isEmpty())
                throw new NoSuchElementException();

            T minItem = items.get(0);
            T lastItem = items.remove(items.size() - 1);
            if (items.isEmpty())
                return lastItem;

            items.set(0, lastItem);
            siftDown(0);
            this.size = items.size();
            return minItem;
        }

        /**
         * 向上调整
         * @param index
         */
        public void siftUp(int index) {
            T intent = items.get(index);
            while (index > 0) {
                int pindex = (index - 1)/2;
                T parent = items.get(pindex);
                if (intent.compareTo(parent) < 0) {
                    items.set(index, parent);
                    index = pindex;
                } else {
                    break;
                }
            }
            items.set(index, intent);
        }

        /**
         * 向下调整
         * @param index
         */
        public void siftDown(int index) {
            T intent = items.get(index);
            int l_cindex = index*2 + 1;
            while (l_cindex < items.size()) {
                T minChild = items.get(l_cindex);
                int min_cindex = l_cindex;

                int r_cindex = l_cindex + 1;
                if (r_cindex < items.size()) {
                    T rChild = items.get(l_cindex + 1);
                    if (rChild.compareTo(minChild) < 0) {
                        minChild = rChild;
                        min_cindex = r_cindex;
                    }
                }

                if (minChild.compareTo(intent) < 0) {
                    items.set(index, minChild);
                    index = min_cindex;
                    l_cindex = index*2 + 1;
                } else {
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}
