package org.buaa.nlp.cj.codingInterviewGuide._9_chapter;

/**
 * Created by whisky-yonk on 10/6/2015.
 */
public class PrintRandM {
    public void printRandM(int[] arr, int m) {
        if (arr == null || arr.length == 0 || m < 0)
            return;
        m = Math.min(m, arr.length);
        int count = 0;
        int i = 0;
        while (count < m) {
            i = (int) (Math.random() * (arr.length - count));
            System.out.println(arr[i]);
            swap(arr, arr.length-count-1, i);
            count++;
        }
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
    public static void main(String[] args) {

    }
}
