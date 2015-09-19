package org.buaa.nlp.cj._360xiaozhao;

import java.util.Scanner;

/**
 * Created by whisky-yonk on 9/15/2015.
 */
public class Main {
        public static void main(String args[])
        {
            Scanner cin = new Scanner(System.in);
            int a, b, c, d, e;
            a = cin.nextInt();
            while(a > 0)
            {
                b = cin.nextInt();
                c = cin.nextInt();
                d = cin.nextInt();
                e = cin.nextInt();
                int sum = b + c + d + e;
                if (b >= 60 && c >= 60 && d >= 90 && e >= 90 && sum >= 310) {
                    if (sum >= 350) {
                        System.out.println("Gongfei");
                    } else {
                        System.out.println("Zifei");
                    }
                } else {
                    System.out.println("Fail");
                }
                a--;
            }
        }
}
