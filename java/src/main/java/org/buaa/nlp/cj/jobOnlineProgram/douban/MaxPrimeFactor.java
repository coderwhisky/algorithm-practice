package org.buaa.nlp.cj.jobOnlineProgram.douban;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/20.
 */
public class MaxPrimeFactor {
//    private static long N = 100000000l;
//    private static long[] prims = new long[N+1l];// is prime if prim[i] == 0;
    private static int N = 100000;
    private static int[] prims = new int[N+1];
//    private static List<Long> prims = new ArrayList<>();

    public static void isPrime() {
        prims[0] = 1;
//        prims.set(0, 1l);
        prims[1] = 1;
//        prims.set(1, 1l);
        for (int i = 2; i < Math.pow(N,0.5); i++) {
//        for (int i = 2; i < N+1; i++) {
            int k = 2;
            while (i * k < N +1) {
                prims[i*k] = 1;
                k++;
            }
        }
    }

    public static void isPrime2() {
        prims[0] = 1;
        prims[1] = 1;
        int prim = 2;
        while (prim < N+1) {
            // 划去 prim 的倍数
            for (int i = prim * prim; i < N+1; i += prim) {
                prims[i] = 1;
            }

            // 找到下一个素数
            prim = prim+1;
            for (int i = prim; i < N+1; i++) {
                if (prims[i] == 0) {
                    prim = i;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
//        isPrime();
        isPrime2();
        int k = 0;
        for (int i = 0; i < N+1; i ++) {
            if (prims[i] == 0) {
                k++;
                System.out.print(i + " ");
                if (k % 10 == 0)
                    System.out.println();
            }
        }
        System.out.println(k);
    }
}
