package org.buaa.nlp.cj.jobOnlineProgram.wangyi;

import java.util.Scanner;

/**
 * Created by Administrator on 2015/10/9.
 */
public class _2_ {
    public static int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        } else if (b == 0) {
            return a;
        }else {
            return gcd(b, a%b);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String l1 = scanner.nextLine();
            int n = Integer.valueOf(l1.trim().split(" ")[0]);
            int a = Integer.valueOf(l1.trim().split(" ")[1]);

            String l2 = scanner.nextLine();
            String[] bs = l2.trim().split(" ");
            int[] b = new int[bs.length];
            for (int i = 0; i < bs.length; i++) {
                b[i] = Integer.valueOf(bs[i]);
            }

            int c = a;
            if (c <= 0) {
                System.out.println(c);
            } else {
                for (int i = 0; i < b.length; i++) {
                    if (b[i] <= c) {
                        c += b[i];
                    } else {
                        c += gcd(b[i], c);
                    }
                }
                System.out.println(c);
            }
        }
    }
}
