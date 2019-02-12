package org.buaa.nlp.cj.baseAlgorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/12.
 */
public class QuickSort {
    public void quickSort(List<Integer> list, int left, int right) {
        int low = left;
        int high = right;
        int pivot = list.get(low);
        while (low < high) {
            while ((low < high) && (list.get(high) > pivot)) high--;
            list.set(low, list.get(high));
            while ((low < high) && (list.get(low) <= pivot)) low++;
            list.set(high, list.get(low));
        }
        list.set(low, pivot);
        System.out.println(list.toString());
        if (low > left)
            quickSort(list, left, low-1);
        if (high < right)
            quickSort(list, low+1, right);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(40);
        list.add(3);
        list.add(29);
        list.add(7);
        list.add(35);
        list.add(4);
        list.add(866);
        list.add(123);
        list.add(56);
        System.out.println(list.toString());
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(list, 0, list.size()-1);
        System.out.println(list.toString());
    }
}
