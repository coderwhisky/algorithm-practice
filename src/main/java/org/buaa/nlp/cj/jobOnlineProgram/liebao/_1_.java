package org.buaa.nlp.cj.jobOnlineProgram.liebao;

import java.util.Scanner;

/**
 * Created by whisky-yonk on 10/14/2015.
 */
public class _1_ {
    private static int N = 102;
    private static long[] sum = new long[N];
    private static long[][] tmp = new long[N][N];
    private static long[] fact = new long[N];

    public static void factorial() {
        for (int i = 0; i < N; i++) {
            fact[i] = (i==0)? 1 : i*fact[i-1];
        }
    }

    public static void countRes() {
        for (int i = 1; i < N; i++) sum[i] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (i == j) {
                    tmp[i][j] = fact[i]%10000;
                } else if(i ==1) {
                    tmp[i][j] = 1;
                } else {
                    tmp[i][j] = (i*tmp[i][j-1] + i*tmp[i-1][j-1])%10000;
                }
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= i; j++) {
                sum[i] += tmp[j][i];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        factorial();
        countRes();
        while (n > 0) {
            int cs = scanner.nextInt();
            long ser = sum[cs];
            System.out.println(ser);
            n--;
        }

//        for (int i = 1; i < 100; i++) {
//            System.out.println(sum[i]);
//        }
    }
}
