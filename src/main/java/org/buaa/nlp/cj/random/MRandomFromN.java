package org.buaa.nlp.cj.random;

import java.util.Arrays;

/**
 * 蓄水池算法，从N个球中随机选取M个球，使得每个球被选中的概率都是M/N
 * Created by whisky-yonk on 10/6/2015.
 */
public class MRandomFromN {
    public static int[] mRandomFromN(int n, int m) {
        int[] ser = new int[m];
        for (int i = 1; i <= m; i++)
            ser[i-1] = i;
        for (int k = m+1; k <= n; k++) {
            int r = (int) (Math.random()*k + 1);
            if (r <= m) {
                int r2 = (int) (Math.random()*m);
                ser[r2] = k;
            }
        }
        return ser;
    }

    public static void main(String[] args) {
        int n = 100;
        int m = 10;
        int[] res = mRandomFromN(n, m);
        System.out.println(Arrays.toString(res));
    }
}
