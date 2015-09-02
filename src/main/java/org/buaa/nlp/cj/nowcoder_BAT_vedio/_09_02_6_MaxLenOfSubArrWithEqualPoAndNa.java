package org.buaa.nlp.cj.nowcoder_BAT_vedio;

/**
 * Created by Administrator on 2015/9/2.
 */
public class _09_02_6_MaxLenOfSubArrWithEqualPoAndNa {
    public int maxLenOfSubArr(int[] arr) {
        if (arr.length < 2)
            return 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = -1;
            } else if (arr[i] > 0) {
                arr[i] = 1;
            }
        }

    }
    public static void main(String[] args) {

    }
}
